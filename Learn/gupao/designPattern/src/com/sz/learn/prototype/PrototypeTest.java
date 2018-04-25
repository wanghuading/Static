package com.sz.learn.prototype;

/**
 * @Author whd
 * @Date 2018/4/25 0:02
 * @Description
 **/
public class PrototypeTest {
    public static void main(String[] args) {
        try {
            DeepClone deepClone = new DeepClone();
            DeepClone deepClone1 = (DeepClone) deepClone.clone();
            System.out.println(deepClone.getMonkey() == deepClone1.getMonkey());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
