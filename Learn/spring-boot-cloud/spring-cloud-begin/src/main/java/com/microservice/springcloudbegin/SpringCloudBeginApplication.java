package com.microservice.springcloudbegin;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudBeginApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringCloudBeginApplication.class);
//		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.setWebEnvironment(true);
		application.run(args);
//		SpringApplication.run(SpringCloudClientConfigApplication.class, args);
	}


}
