package com.sz.learn.template;

/**
 * @Author whd
 * @Date 2018/4/27 15:56
 * @Description
 **/
public class Person {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(){}

    private String id;
    private String realName;
    private String idCard;
    private String address;
}
