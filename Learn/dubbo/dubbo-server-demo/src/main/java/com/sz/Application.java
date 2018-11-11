package com.sz;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:**/provider.xml"});
        context.start();
        // 按任意键退出
        System.in.read();


        // 容器加载启动
//        Main.main(new String[]{"spring", "log4j"});
    }
}
