package com.microservice.userapi.service;

import com.microservice.userapi.domain.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    public boolean save(User user);
    public Collection<User> findAll();
}
