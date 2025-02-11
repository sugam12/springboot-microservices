package com.practice.gateway;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class BeanConfiguration {

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


    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient));
    }
}
