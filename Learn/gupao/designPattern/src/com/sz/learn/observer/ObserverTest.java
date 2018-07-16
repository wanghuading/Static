package com.sz.learn.observer;

import java.lang.reflect.Method;

/**
 * @Author whd
 * @Date 2018/4/30 14:49
 * @Description
 **/
public class ObserverTest {
    public static void main(String[] args) {
        try {

            // 观察者
            Observer observer = new Observer();
            Method method = Observer.class.getMethod("advice", null);

            // 被观察者
            Subject subject = new Subject();
            subject.addLisenter(EventType.ADD, observer, method);


            subject.add();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
