package com.microservice.userconsumer.web;

import com.microservice.userapi.domain.User;
import com.microservice.userconsumer.service.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserProxy userProxy;


    @PostMapping("/consumer/user/save")
    public void save(@RequestBody User user) {
        userProxy.save(user);
    }

    @GetMapping("/consumer/user/finaAll")
    public Collection<User> findAll() {
        return userProxy.findAll();
    }
}
