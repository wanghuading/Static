package com.sz.learn.strategy;

/**
 * @Author whd
 * @Date 2018/4/26 22:54
 * @Description
 **/
public enum CommunicaEnum {
    APP(new App()), FACE(new Face()), TEL(new Telephone());

    private Communication communication;
    CommunicaEnum(Communication communication) {
        this.communication = communication;
    }

    public Communication get() {
        return this.communication;
    }
}
