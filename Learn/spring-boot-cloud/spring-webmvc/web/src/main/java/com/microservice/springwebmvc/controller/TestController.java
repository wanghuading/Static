package com.microservice.springwebmvc.controller;

import com.microservice.springwebmvc.pojo.TestUser;
import com.microservice.springwebmvc.repository.TestRepository;
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

    public TestController(TestRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/webmvc/insert")
    public Object insert(@RequestBody TestUser test) {
        return repository.save(test);
    }
}
