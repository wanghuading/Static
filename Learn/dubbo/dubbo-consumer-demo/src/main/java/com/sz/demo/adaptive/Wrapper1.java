/*
package com.sz.demo.adaptive;

public class Wrapper1 {
    public static String[] pns;
    public static java.util.Map pts;
    public static String[] mns;
    public static String[] dmns;
    public static Class[] mts0;
    public static Class[] mts1;

    public String[] getPropertyNames() {
        return pns;
    }

    public boolean hasProperty(String n) {
        return pts.containsKey($1);
    }

    public Class getPropertyType(String n) {
        return (Class) pts.get($1);
    }

    public String[] getMethodNames() {
        return mns;
    }

    public String[] getDeclaredMethodNames() {
        return dmns;
    }

    public void setPropertyValue(Object o, String n, Object v) {
        com.sz.service.UserServiceImpl w;
        try {
            w = ((com.sz.service.UserServiceImpl) $1);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException("Not found property \"" + $2 + "\" filed or setter method in class com.sz.service.UserServiceImpl.");
    }

    public Object getPropertyValue(Object o, String n) {
        com.sz.service.UserServiceImpl w;
        try {
            w = ((com.sz.service.UserServiceImpl) $1);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException("Not found property \"" + $2 + "\" filed or setter method in class com.sz.service.UserServiceImpl.");
    }

    public Object invokeMethod(Object o, String n, Class[] p, Object[] v) throws java.lang.reflect.InvocationTargetException {
        com.sz.service.UserServiceImpl w;
        try {
            w = ((com.sz.service.UserServiceImpl) $1);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        try {
            if ("getUser".equals($2) && $3.length == 1 && $3[0].getName().equals("java.lang.String")) {
                return ($w) w.getUser((java.lang.String) $4[0]);
            }
            if ("getUser".equals($2) && $3.length == 2 && $3[0].getName().equals("java.lang.String") && $3[1].getName().equals("int")) {
                return ($w) w.getUser((java.lang.String) $4[0], ((Number) $4[1]).intValue());
            }
        } catch (Throwable e) {
            throw new java.lang.reflect.InvocationTargetException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchMethodException("Not found method \"" + $2 + "\" in class com.sz.service.UserServiceImpl.");
    }
}*/
