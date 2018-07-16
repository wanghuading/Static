package com.microservice.demo3.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Author whd
 * @Date 2018/6/2 17:41
 * @Description
 **/
@Configuration
public class WebFluxConfiguration {

    @Bean
    public RouterFunction<ServerResponse> saveUser(TestHandler testHandler) {
        System.out.printf("config Current Thread Name %s", Thread.currentThread().getName());
        return route(POST("/webflux/test/insert"), testHandler::save);
    }
}
