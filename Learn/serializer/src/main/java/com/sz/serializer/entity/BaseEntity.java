package com.sz.serializer.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private String baseId;

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }
}
