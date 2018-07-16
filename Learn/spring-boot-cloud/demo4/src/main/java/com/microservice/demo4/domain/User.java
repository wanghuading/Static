package com.microservice.demo4.domain;

import com.microservice.demo4.validate.CarNumAnnotation;

import javax.validation.constraints.NotNull;

public class User {
    private int id;
    private String name;
    @NotNull
    @CarNumAnnotation
    private String cardNum;

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

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
