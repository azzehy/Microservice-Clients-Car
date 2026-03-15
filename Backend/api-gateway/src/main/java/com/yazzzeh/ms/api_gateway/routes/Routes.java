package com.yazzzeh.ms.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> clientServiceRoute(){
        return GatewayRouterFunctions.route("client_service")
                .route(RequestPredicates.path("/api/clients/**"), HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri("http://localhost:8081"))
                .build();
    }


    @Bean
    public RouterFunction<ServerResponse> carServiceRoute(){
        return GatewayRouterFunctions.route("cars_service")
                .route(RequestPredicates.path("/api/cars/**"), HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri("http://localhost:8082"))
                .build();
    }
}
