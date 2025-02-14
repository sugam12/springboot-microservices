package com.practice.gateway.validator;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> unprotectedUrls = List.of("/login");

    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> unprotectedUrls.stream().noneMatch(uri->serverHttpRequest.getURI().getPath().contains(uri));
}
