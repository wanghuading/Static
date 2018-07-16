package com.microservice.springcloudbegin.observer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEventListenerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

//        MyApplicationEvent e = new MyApplicationEvent("hello, world");
        // 注册监听器
        context.addApplicationListener(
                (e) -> {
                    System.out.println(e.getSource());
                    System.out.println("成功应用lambda");
                }
        );

        context.refresh();
        // 发布事件
        context.publishEvent(new MyApplicationEvent("hello,world"));
    }
}
