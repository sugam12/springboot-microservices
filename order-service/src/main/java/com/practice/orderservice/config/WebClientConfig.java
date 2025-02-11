package com.practice.orderservice.config;

import com.practice.orderservice.client.InventoryClient;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
// to connect locally
    @Bean
    @LoadBalanced
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create()
                                .resolver(DefaultAddressResolverGroup.INSTANCE)
                ))
                .baseUrl("http://eureka-client-b")
                .filter(filterFunction)
                .build();
    }

    //to connect www
    /*@Bean
    @LoadBalanced
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://eureka-client-b")
                .filter(filterFunction)
                .build();
    }*/

    @Bean
    public InventoryClient employeeClient() {
        WebClientAdapter webClientAdapter = WebClientAdapter.create(employeeWebClient());
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder().exchangeAdapter(webClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
}
