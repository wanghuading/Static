package com.sz.learn.agent.jdk;

import com.sz.learn.agent.Chef;
import com.sz.learn.agent.Person;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author whd
 * @Date 2018/4/26 10:34
 * @Description
 **/
public class JdkAgentTest {
    public static void main(String[] args) {
        JdkAgent jdkAgent = new JdkAgent();
        Person person = (Person) jdkAgent.getInstance(new Chef());
        person.cook();


        try {
            // 输出代理类
            byte[] bytes = ProxyGenerator.generateProxyClass(person.getClass().getName(), person.getClass().getInterfaces());
            FileOutputStream fos = new FileOutputStream(new File("E:\\JdkAgent.class"));
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
