package com.sz.learn.observer;

/**
 * @Author whd
 * @Date 2018/4/30 14:39
 * @Description
 **/
public class Subject extends EventListener {
    public void add() {
        System.out.println("add");
        trigger(EventType.ADD);
    }
}
