package com.sz.serializer;

import java.io.IOException;

public interface ISerializer {
    <T> byte[] serialization(T obj);

    <T> T deserialization(byte[] bytes);

    <T> void serializationToFile(T obj, String path);

    <T> T deserializationFromFile(String path);
}
