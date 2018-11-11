package com.sz.service;

import com.sz.entity.User;

import java.io.Serializable;

public interface UserService {
    User getUser(String name);

    User getUser(String name, int age);
}
