package com.bdb.gw.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbdRoutes {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public RouteLocator dbdRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("dbd-auth", r -> r.path("/v1/auth/**").uri("lb://dbd-user"))
                .route("dbd-user", r -> r.path("/v1/user/**").filters(f -> f.filter(jwtFilter)).uri("lb://dbd-user"))
                .route("dbd-resource", r -> r.path("/v1/resource/**").filters(f -> f.filter(jwtFilter)).uri("lb://dbd-resource"))
                .build();
    }
}
