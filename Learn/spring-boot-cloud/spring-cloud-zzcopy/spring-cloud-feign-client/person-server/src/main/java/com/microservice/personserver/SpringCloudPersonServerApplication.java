package com.microservice.personserver;

import com.microservice.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@Import(WebConfig.class)
public class SpringCloudPersonServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPersonServerApplication.class, args);
    }
}
