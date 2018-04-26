package com.sz.learn.agent.custom;

import java.lang.reflect.Method;

/**
 * @Author whd
 * @Date 2018/4/26 17:03
 * @Description
 **/
public interface CustomInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
