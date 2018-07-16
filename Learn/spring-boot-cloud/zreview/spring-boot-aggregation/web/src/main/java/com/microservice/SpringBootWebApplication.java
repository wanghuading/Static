package com.microservice;

import com.microservice.persistence.config.datasource.MultiDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class SpringBootWebApplication
        implements ErrorPageRegistrar {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
    }
}
