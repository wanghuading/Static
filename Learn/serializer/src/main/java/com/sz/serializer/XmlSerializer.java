package com.sz.serializer;


import com.thoughtworks.xstream.XStream;

public class XmlSerializer implements ISerializer {
    public <T> byte[] serialization(T obj) {
        XStream xStream = new XStream();
        String str = xStream.toXML(serialization(obj));
        System.out.println(str);
        return str.getBytes();
    }

    public <T> T deserialization(byte[] bytes) {
        XStream xStream = new XStream();
        return (T) xStream.fromXML(new String(bytes));
    }

    public <T> void serializationToFile(T obj, String path) {

    }

    public <T> T deserializationFromFile(String path) {
        return null;
    }
}
