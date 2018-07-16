package com.microservice.springcloudturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
//@EnableTurbine
public class SpringCloudTurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTurbineApplication.class, args);
	}
}
