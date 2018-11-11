package com.sz.demo.mock;

import com.sz.entity.User;
import com.sz.service.UserService;

public class TestMock implements UserService {
    @Override
    public User getUser(String s) {
        User user = new User();
        user.setName("默认值1");
        return user;
    }

    @Override
    public User getUser(String s, int i) {
        User user = new User();
        user.setName("默认值2");
        return user;
    }
}
