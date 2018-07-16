package com.microservice.springbootexperience.controller;

import com.microservice.springbootexperience.pojo.TestUser;
import com.microservice.springbootexperience.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author whd
 * @Date 2018/6/2 16:46
 * @Description
 **/
@RestController
public class TestController {
    private TestRepository repository;
    @Autowired
    public TestController(TestRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/webmvc/insert")
    public Object insert(@RequestBody TestUser test) {
        return repository.save(test);
    }
}
