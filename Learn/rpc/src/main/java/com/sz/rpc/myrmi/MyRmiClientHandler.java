package com.sz.rpc.myrmi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyRmiClientHandler implements InvocationHandler {
    private String host;
    private int port;
    MyRmiClientHandler(String host , int port) {
        this.host = host;
        this.port = port;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        return new MyRmiClient().lookup(host, port, rpcRequest);
    }
}
