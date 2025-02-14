package com.practice.gateway;

import com.practice.gateway.authentication.AuthenticationFilter;
import com.practice.gateway.authentication.RequestFilter;
import com.practice.gateway.dto.InventoryDto;
import com.practice.gateway.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private RequestFilter requestFilter;

    @Autowired
    private AuthenticationFilter authenticationFilter;

    /*@Bean
    public RouteLocator routes(RouteLocatorBuilder builder){

        *//*GatewayFilter rewriteFilter = new RewritePathGatewayFilterFactory()
                .apply(config -> config.setRegexp("/original-path")
                        .setReplacement("/eventual-path"));
        Route route = Route.async()
                .id(UUID.randomUUID().toString())
                .filter(new OrderedGatewayFilter(rewriteFilter, 0))
                .predicate(new PathRoutePredicateFactory()
                        .apply(config -> config.setPatterns(List.of("/original-path"))))
                .uri("http://localhost:" + port)
                .build();*//*
        return builder.routes()
                .route(r -> r
                        .path("/inventory/**")
                        .filters(f->f.stripPrefix(1))
                        .uri("lb://inventory-service")
                        ).build();
    }*/


    /*@Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient));
    }*/


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        // adding 2 rotes to first microservice as we need to log request body if method is POST
        return builder.routes()
                .route("order-service", r -> r.path("/order")
                        .and().method("POST")
                        .and().readBody(OrderDto.class, s -> true).filters(f -> f.filters(requestFilter, authenticationFilter))
                        .uri("lb://order-service"))
                .route("order-service", r -> r.path("/order")
                        .and().method("GET").filters(f -> f.filters(authenticationFilter))
                        .uri("lb://order-service"))
                .route("inventory-service", r -> r.path("/inventory")
                        .and().method("POST")
                        .and().readBody(InventoryDto.class, s -> true).filters(f -> f.filters(requestFilter, authenticationFilter))
                        .uri("lb://inventory-service"))
                .route("inventory-service", r -> r.path("/inventory")
                        .and().method("GET").filters(f -> f.filters(authenticationFilter))
                        .uri("lb://inventory-service"))
                /* .route("auth-server",r -> r.path("/login")
                         .uri("http://localhost:8088"))*/
                .build();
    }
}
