package com.microservice.springcloudhystixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudHystixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystixDashboardApplication.class, args);
	}
}
