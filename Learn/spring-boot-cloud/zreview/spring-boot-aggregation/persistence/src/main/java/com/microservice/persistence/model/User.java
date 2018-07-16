package com.microservice.persistence.model;

import com.microservice.persistence.validater.UserValidator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class User {
    private int id;
    @NotEmpty
    @UserValidator
    private String name;

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
}
