package com.sz.learn.observer;

import java.lang.reflect.Method;

/**
 * @Author whd
 * @Date 2018/4/30 14:07
 * @Description
 **/
public class EventEntity {
    private Object target;
    private Method targetMethod;
    private Object[] methodParam;

    EventEntity(Object target, Method targetMethod, Object[] methodParam) {
        this.target = target;
        this.targetMethod = targetMethod;
        this.methodParam = methodParam;
    }

    public Object getTarget() {
        return target;
    }

    public EventEntity setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public EventEntity setTargetMethod(Method targetMethod) {
        this.targetMethod = targetMethod;
        return this;
    }

    public Object[] getMethodParam() {
        return methodParam;
    }

    public EventEntity setMethodParam(Object[] methodParam) {
        this.methodParam = methodParam;
        return this;
    }
}
