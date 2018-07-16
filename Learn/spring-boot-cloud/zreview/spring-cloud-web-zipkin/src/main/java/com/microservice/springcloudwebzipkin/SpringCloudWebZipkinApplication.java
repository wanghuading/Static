package com.microservice.springcloudwebzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
//import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinStreamServer
//@EnableZipkinServer
public class SpringCloudWebZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWebZipkinApplication.class, args);
	}
}
