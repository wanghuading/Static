package com.sz.learn.prototype;

/**
 * @Author whd
 * @Date 2018/4/25 0:02
 * @Description
 **/
public class PrototypeTest {
    public static void main(String[] args) {
        try {
            SerialDeepClone serialDeepClone = new SerialDeepClone();
            SerialDeepClone serialDeepClone1 = (SerialDeepClone) serialDeepClone.clone();
            System.out.println(serialDeepClone.getMonkey() == serialDeepClone.getMonkey());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
