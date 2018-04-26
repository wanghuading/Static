package com.sz.learn.agent.jdk;

import com.sz.learn.agent.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author whd
 * @Date 2018/4/26 10:20
 * @Description jdk动态代理
 **/
public class JdkAgent implements InvocationHandler {

    private Person person;

    public Object getInstance(Person person) {
        this.person = person;
        Class clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("备好菜、辅料等");
        method.invoke(this.person,args);
        System.out.println("清理废料等");
        return null;
    }
}
