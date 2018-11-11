package com.sz.rpc.rmi.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8614826977357196417L;
    private int id;
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
