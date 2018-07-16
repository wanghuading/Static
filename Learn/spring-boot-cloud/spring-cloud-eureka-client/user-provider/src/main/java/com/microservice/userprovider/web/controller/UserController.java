package com.microservice.userprovider.web.controller;

import com.microservice.userapi.domain.User;
import com.microservice.userprovider.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user/save")
    public void save(@RequestBody User user) {
        if (userService.save(user)) {
            System.out.printf("保存user【%s】成功", user.getName());
        } else {
            System.out.printf("保存user【%s】失败",user.getName());
        }
    }

    @GetMapping("/user/findAll")
    public Collection<User> findAll() {
        Collection<User> users = userService.findAll();
        System.out.printf("返回%s个用户",users.size());
        return users;
    }
}
