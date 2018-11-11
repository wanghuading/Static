package com.sz.rpc.myrmi;

import java.io.Serializable;

public class RpcRequest implements Serializable {
    // 参数
    private Object[] parameters;
    // 方法名称
    private String methodName;

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
