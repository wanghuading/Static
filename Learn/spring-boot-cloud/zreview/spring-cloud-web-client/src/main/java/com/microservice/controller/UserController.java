package com.microservice.controller;

import com.microservice.feign.UserService;
import com.microservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @PostMapping("/user/client/add")
    public boolean save(User user) {
        logger.info("web-cliet（add）链路");
        return userService.save(user);
    }
    @GetMapping("/user/client/find/all")
    public Collection<User> findAll() {
        logger.info("web-cliet（findall）链路");
        Collection<User> users = userService.findAll();
        return users;
    }

}
