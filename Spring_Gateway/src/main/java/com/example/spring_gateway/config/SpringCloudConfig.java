package com.example.spring_gateway.config;

import com.example.spring_gateway.filter.AuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    private final AuthenticationFilter authenticationFilter;

    public SpringCloudConfig(AuthenticationFilter authenticationFilter) {
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/test/**")
                        .filters(f -> f.filter(authenticationFilter).stripPrefix(1))
                        .uri("http://localhost:8085/"))
                .route(r -> r.path("/user/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
