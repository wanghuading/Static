package com.microservice.personserver;

import com.microservice.personapi.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudPersonServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPersonServerApplication.class, args);
    }
}
