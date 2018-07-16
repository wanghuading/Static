package com.microservice.demo4.controller;

import com.microservice.demo4.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
//@RequestMapping("/user")
public class UserController {
    @PostMapping("/getUser")
    public User getUser(@Valid @RequestBody User user) {
        return user;
    }
}
