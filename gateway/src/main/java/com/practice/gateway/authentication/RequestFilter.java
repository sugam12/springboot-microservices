package com.practice.gateway.authentication;

import com.practice.gateway.dto.InventoryDto;
import com.practice.gateway.dto.OrderDto;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class RequestFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Object body = exchange.getAttribute("cachedReqBodyObject");
        if (body instanceof InventoryDto) {
            System.out.println("inventory request body:" + body);
        } else if (body instanceof OrderDto) {
            System.out.println("Order request body:" + body);
        }
        return chain.filter(exchange);
    }
}
