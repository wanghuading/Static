package com.microservice.springcloudhystrixclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableCircuitBreaker
@EnableTurbine
public class SpringCloudHystrixClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixClientApplication.class, args);
	}
}
