package com.microservice.springcloudwebeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudWebEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWebEurekaApplication.class, args);
	}
}
