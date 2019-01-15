package com.sz.DynamicCode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(String[] args) {
        java.lang.reflect.Proxy.newProxyInstance(null, null, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
    }
}
