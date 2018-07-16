package com.microservice.personapi.service;

import com.microservice.personapi.domain.Person;
import com.microservice.personapi.service.fallback.PersonServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@FeignClient(value = "person-server", fallback = PersonServiceFallback.class)
public interface PersonService {
    @PostMapping("/person/save")
    boolean save(/*@RequestBody */Person person);
    @GetMapping("/person/find/all")
    Collection<Person> findAll();
}
