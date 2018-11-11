package com.sz.service;

import com.sz.entity.User;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String name) {
        User u = new User();
        u.setAge(1);
        u.setName("cluster1"+name);
        u.setId(1);
        return u;

    }

    @Override
    public User getUser(String name, int age) {
        User u = new User();
        u.setId(2);
        u.setAge(age);
        u.setName(name);
        return u;
    }
}
