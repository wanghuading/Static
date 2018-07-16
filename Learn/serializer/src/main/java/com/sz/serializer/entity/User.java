package com.sz.serializer.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User extends BaseEntity {
    private static final long serialVersionUID = 2648464603803709319L;
    private int id;
    private String name;
    private transient String nameCopy;
//    private UserRef userRef;
    public static int num = 5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCopy() {
        return nameCopy;
    }

    public void setNameCopy(String nameCopy) {
        this.nameCopy = nameCopy;
    }

    /*public UserRef getUserRef() {
        return userRef;
    }

    public void setUserRef(UserRef userRef) {
        this.userRef = userRef;
    }*/

    /**
     * 绕过transient
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(nameCopy);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        nameCopy = (String) objectInputStream.readObject();
    }
}
