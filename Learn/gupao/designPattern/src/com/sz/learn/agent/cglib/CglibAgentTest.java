package com.sz.learn.agent.cglib;

import com.sz.learn.agent.Agented;
import sun.misc.ProxyGenerator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author whd
 * @Date 2018/4/26 10:58
 * @Description
 **/
public class CglibAgentTest {
    public static void main(String[] args) {
        CglibAgent cglibAgent = new CglibAgent();
        Agented agented = (Agented) cglibAgent.getInstance(new Agented());
        agented.cook();


        try {
            // 输出代理类
            byte[] bytes = ProxyGenerator.generateProxyClass(agented.getClass().getName(), agented.getClass().getInterfaces());
            FileOutputStream fos = new FileOutputStream(new File("E:\\CglibAgent.class"));
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
