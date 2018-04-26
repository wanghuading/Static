package com.sz.learn.agent.custom;

import com.sz.learn.agent.Person;

import java.lang.reflect.Method;

/**
 * @Author whd
 * @Date 2018/4/26 17:06
 * @Description
 **/
public class CustomAgent implements CustomInvocationHandler {
    public Person target;

    public Object getInstance(Person person) {
        this.target = person;
        return CustomProxy.newProxyInstance(new CustomClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("自己去买菜");
        method.invoke(this.target, args);
        System.out.println("自己洗碗");
        return null;
    }
}
