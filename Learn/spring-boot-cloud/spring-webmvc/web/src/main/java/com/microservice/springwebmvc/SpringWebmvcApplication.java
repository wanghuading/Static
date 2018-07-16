package com.microservice.springwebmvc;

import com.microservice.springwebmvc.other.OtherEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebmvcApplication {

	public static void main(String[] args) {
		OtherEntity otherEntity = new OtherEntity();
		otherEntity.setCompanyName("jo");
		System.out.println(otherEntity.getCompanyName());
		SpringApplication.run(SpringWebmvcApplication.class, args);
	}
}
