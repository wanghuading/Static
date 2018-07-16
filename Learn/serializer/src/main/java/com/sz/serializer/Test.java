package com.sz.serializer;

import com.sz.serializer.entity.User;
import com.sz.serializer.entity.UserRef;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("whd");
        user.setNameCopy("cl");
        user.setBaseId("base");
        UserRef userRef = new UserRef();
//        user.setUserRef(userRef);
//        user.getUserRef().setTest("tset");
        System.out.println(user);

        /*try {
            JavaSerializer javaSerializer = new JavaSerializer();
            byte[] bytes = javaSerializer.serialization(user);
            User.num = 10;
            System.out.println(bytes);

            User clone = javaSerializer.deserialization(bytes);
            System.out.println(clone);
            System.out.println(clone.num);
        } catch (Exception e) {
            System.out.printf("序列化错误%s",e.getCause());
        }*/

        /*try {
            JavaSerializer javaSerializer = new JavaSerializer();
            javaSerializer.serializationToFile(user, "D:\\serial");

            User clone = javaSerializer.deserializationFromFile("D:\\serial");
            System.out.println(clone.getNameCopy());
            System.out.println(clone.getBaseId());
            System.out.println(clone.getUserRef().getTest());

        } catch (Exception e) {
            System.out.printf("序列化错误%s",e.getCause());
        }*/


        /*try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\serial"));
            oos.flush();
            oos.writeObject(user);
            System.out.println(new File("D:\\serial").length());
            oos.flush();
            oos.writeObject(user);
            System.out.println(new File("D:\\serial").length());



        } catch (Exception e) {
            System.out.printf("序列化错误%s",e.getCause());
        }*/

        XmlSerializer xmlSerializer = new XmlSerializer();
        xmlSerializer.serialization(user);
    }
}
