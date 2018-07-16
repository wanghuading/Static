package com.microservice.springcloudwebsleuth.web;

import com.microservice.springcloudwebsleuth.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private RestTemplate restTemplate;
    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/sleuth/user/find/all")
    public Collection<User> findAll() {
        logger.info("请求链开端");
        String url = "http://spring-cloud-web-zuul/spring-cloud-web-client" +
                "/user/client/find/all";
        return restTemplate.getForObject(url, Collection.class);
    }

    @RequestMapping("/sleuth/user/add")
    public boolean add(@RequestBody User user) {
        logger.info("请求链开端");
        String url = "http://spring-cloud-web-zuul/spring-cloud-web-client" +
                "/user/client/add";
        return restTemplate.postForObject(url, user, Boolean.class);
    }
}
