package com.microservice.springcloudsleuth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class BeginController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private RestTemplate restTemplate;

    @Autowired
    public BeginController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    public String start() {
        String returnValue = "hello,world";
        logger.info("{} start() {}", getClass().getSimpleName(), returnValue);
        return returnValue;
    }

    @GetMapping("/toZuul/personClient/find/all")
    public Collection toZuul() {
        logger.info("spring-cloud#zuul()");
        String url = "http://spring-cloud-zuul/person-client/person/find/all";
        return restTemplate.getForObject(url, Collection.class);
    }
}
