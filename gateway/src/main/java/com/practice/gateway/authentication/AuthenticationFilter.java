package com.practice.gateway.authentication;

import com.practice.gateway.validator.RouteValidator;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RefreshScope
public class AuthenticationFilter implements GatewayFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JWTUtl jwtUtl;

    @Autowired
    private AuthUtil authUtil;

    @Value("${authentication.enabled}")
    private boolean authEnabled;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!authEnabled) {
            log.info("Authentication is disabled. Please enable it using \"authentication.enabled\" as true");
            //trigger email if email is enabled
        }
        String token = "";
        ServerHttpRequest request = exchange.getRequest();
        if (routeValidator.isSecured.test(request)) {
            log.info("validating authentication token");
            if (this.isCredentialMissing(request)) {
                log.error("Missing credential info");
                return this.onError(exchange, "Credential Missing Error", HttpStatus.UNAUTHORIZED);
            }
            if (checkCredential(request)) {
                token = authUtil.getToken(request.getHeaders().get("userName").toString(), request.getHeaders().get("role").toString());
            } else {
                token = request.getHeaders().get("Authorization").toString().split(" ")[1];
            }
            if (jwtUtl.isInvalid(token)) {
                return this.onError(exchange, "Auth header Invalid", HttpStatus.UNAUTHORIZED);
            } else {
                log.info("Authorization is success");
            }
            this.populateRequestWithHeaders(exchange, token);
        }
        return chain.filter(exchange);
    }

    private void populateRequestWithHeaders(ServerWebExchange exchange, String token) {
        Claims claims = jwtUtl.getAllClaims(token);
        exchange.getRequest().mutate()
                .header("id", String.valueOf(claims.get("id")))
                .header("role", String.valueOf(claims.get("role")))
                .build();
    }

    private Mono<Void> onError(ServerWebExchange exchange, String credentialMissingError, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private boolean isCredentialMissing(ServerHttpRequest request) {
        return checkCredential(request) && !request.getHeaders().containsKey("Authorization");
    }

    private boolean checkCredential(ServerHttpRequest request) {
        return request.getHeaders().containsKey("userName") && request.getHeaders().containsKey("role");
    }
}
