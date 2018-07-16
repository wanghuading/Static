package com.microservice.springbootexperience;

import com.microservice.springbootexperience.other.OtherEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

	public static void main(String[] args) {
		OtherEntity otherEntity = new OtherEntity();
		otherEntity.setCompanyName("jo");
		System.out.println(otherEntity.getCompanyName());
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
