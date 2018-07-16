package com.microservice.demo.http.message;

import com.microservice.demo.entity.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @Author whd
 * @Date 2018/5/30 13:55
 * @Description
 **/
public class PersonPropertiesHttpMessageConverter extends AbstractHttpMessageConverter<Person> {
    public PersonPropertiesHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }
    @Override
    protected boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Person.class);
    }

    @Override
    protected Person readInternal(Class<? extends Person> aClass, HttpInputMessage httpInputMessage)
            throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = httpInputMessage.getBody();
        Properties properties = new Properties();
        properties.load(inputStream);
        Person person = new Person();
        person.setId(Integer.valueOf(properties.getProperty("person.id")));
        person.setName(properties.getProperty("person.name"));
        return person;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = httpOutputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("id", String.valueOf(person.getId()));
        properties.setProperty("name", person.getName());
        properties.store(outputStream, "Converter Person to the type of properties");
    }
}
