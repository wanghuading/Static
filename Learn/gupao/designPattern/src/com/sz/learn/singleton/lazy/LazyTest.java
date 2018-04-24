package com.sz.learn.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author whd
 * @Date 2018/4/24 18:35
 * @Description
 **/
public class LazyTest {
    public static void main(String[] args) {
        Class innerSingleton = InnerSingleton.class;

        try {
            Class o1 = Class.forName("com.sz.learn.singleton.lazy.InnerSingleton");
            Class c1 = o1.getDeclaredClasses()[0];
            Field field = c1.getDeclaredField("inital");
            field.setAccessible(true);
            System.out.println(field.get(c1));
            field.setBoolean(c1, false);
            System.out.println(field.get(c1));

            /*Constructor<InnerSingleton> c = innerSingleton.getDeclaredConstructor();
            c.setAccessible(true);
            InnerSingleton o1 = null;
            try {
                o1 = c.newInstance();
            } catch (Exception e) {
                System.out.println("忽略错误");
            }

            Class c1 = o1.getClass();
            Field field = c1.getDeclaredField("inital");
            field.setAccessible(true);
            System.out.println(field.get(c1));
            Field field = innerSingleton.getDeclaredField("inital");
            field.setAccessible(true);
            field.set(innerSingleton, false);
            System.out.println(field.get(innerSingleton));
            InnerSingleton o2 = c.newInstance();

            System.out.println(o1 == o2);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
