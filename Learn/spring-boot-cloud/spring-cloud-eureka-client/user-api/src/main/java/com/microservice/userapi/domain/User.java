package com.microservice.userapi.domain;

import org.springframework.util.StringUtils;

import java.util.Objects;

public class User implements Comparable<User>{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public int compareTo(User user) {
        int result = 0;
        if (this.id > user.id) {
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }
}
