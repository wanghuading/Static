package com.microservice.springcloudstream.entity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

import java.io.*;

public class Person implements Serializable {
    private int id;
    private String name;
    public Person() {

    }
    public Person(byte[] payload) {
        byteToObject(payload);
    }

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


    private void byteToObject(byte[] bytes) {
        try {

            Person person = (Person) initObjectMapper().readerWithView(null).forType(Person.class).readValue(bytes);
            BeanUtils.copyProperties(person, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ObjectMapper initObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
