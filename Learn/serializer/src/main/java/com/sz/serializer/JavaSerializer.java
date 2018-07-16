package com.sz.serializer;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.sz.serializer.ISerializer;

import java.io.*;

public class JavaSerializer implements ISerializer {

    public <T> byte[] serialization(T obj) {
        ByteOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bos.getBytes();
    }

    public <T> T deserialization(byte[] bytes) {
        ByteInputStream bis = null;
        ObjectInputStream ois = null;
        T obj = null;
        try {
            bis = new ByteInputStream(bytes, bytes.length);
            ois = new ObjectInputStream(bis);
            obj = (T) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public <T> void serializationToFile(T obj, String path) {
        FileOutputStream fos = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            fos.write(serialization(obj));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public <T> T deserializationFromFile(String path) {
        FileInputStream fis = null;
        try {
            File file = new File(path);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

}
