package com.sz.learn.agent.cglib;

import com.sz.learn.agent.Agented;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author whd
 * @Date 2018/4/26 10:44
 * @Description
 **/
public class CglibAgent implements MethodInterceptor {

    public Object getInstance(Agented agented) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(agented.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("备菜、辅料");
        proxy.invokeSuper(obj, args);
        System.out.println("处理废料");
        return null;
    }
}
