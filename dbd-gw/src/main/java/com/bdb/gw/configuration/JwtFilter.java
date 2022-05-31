package com.bdb.gw.configuration;


import com.dbd.commonlib.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        JwtUtil util = new JwtUtil();

        ServerHttpRequest request = exchange.getRequest();

        if (request.getHeaders().containsKey("authorization")) {
            Claims authorization = util.decodeToken(request.getHeaders().get("authorization").get(0));
            if (authorization == null) {
                System.out.println("+++++++++++++++ bad auth header");
                return exchange.getResponse().setComplete();
            }

            exchange.getRequest().mutate()
                    .header("username", authorization.get("username").toString());
            return chain.filter(exchange);

        } else {
            System.out.println("+++++++++++++++ no auth header");
            return exchange.getResponse().setComplete();
        }


    }
}
