package com.sz.demo;

import com.alibaba.dubbo.container.Main;
import com.sz.entity.User;
import com.sz.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class UserServiceDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/consumer.xml");
        context.start();
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.getUser("user1");
        System.out.println(user.getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Main.main(new String[]{"spring"});
    }
}
