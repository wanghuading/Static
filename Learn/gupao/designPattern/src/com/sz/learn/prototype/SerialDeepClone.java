package com.sz.learn.prototype;

import net.sf.cglib.beans.BeanCopier;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Author whd
 * @Date 2018/4/24 23:57
 * @Description
 **/
public class SerialDeepClone implements Cloneable, Serializable {
    private int k = 1;
    private Monkey monkey;

    public SerialDeepClone() {
        monkey = new Monkey();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return this.reflectDeepClone();
        return this.serialDeepClone();
//        return super.clone();
    }

    private Object serialDeepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();

            oos.close();
            ois.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
      * @Author whd
      * @Date 2018/4/25 12:07
      * @Param []
      * @Return java.lang.Object
      * @Description 待开发
      **/
    private Object reflectDeepClone() {
        Object newObj = null;
        try {
            newObj =  super.clone();
            BeanCopier beanCopier = BeanCopier.create(this.getClass(), newObj.getClass(), false);
            beanCopier.copy(this, newObj, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newObj;
    }


    public Monkey getMonkey() {
        return monkey;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
}
