package com.microservice.feign;

import com.microservice.model.User;

import java.util.Collection;
import java.util.Collections;

public class UserServiceFallback implements UserService{
    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public Collection<User> findAll() {
        return Collections.emptyList();
    }
}
