package com.sz.rpc.myrmi;

import java.lang.reflect.Proxy;

public class MyRmiClientProxy {
    public <T> T clientProxy(final Class<T> interfaceClass, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, new MyRmiClientHandler(host, port));
    }
}
