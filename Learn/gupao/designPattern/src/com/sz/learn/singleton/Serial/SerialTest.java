package com.sz.learn.singleton.Serial;

import java.io.*;

/**
 * @Author whd
 * @Date 2018/4/24 19:31
 * @Description
 **/
public class SerialTest {
    public static void main(String[] args) {
        SerialSingleton s1 = SerialSingleton.getInstance();
        SerialSingleton s2 = null;

        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\serialTest.obj"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream(new File("D:\\serialTest.obj"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SerialSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
