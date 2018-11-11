package com.sz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Cluster1Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:**/cluster1.xml"});
        context.start();
        // 按任意键退出
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
