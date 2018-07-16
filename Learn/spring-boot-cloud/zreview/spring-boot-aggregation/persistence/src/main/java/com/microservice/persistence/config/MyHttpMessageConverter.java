package com.microservice.persistence.config;

import com.microservice.persistence.model.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;

public class MyHttpMessageConverter extends AbstractHttpMessageConverter<User> {
    MyHttpMessageConverter() {
        super(new MediaType("application","properties+user"));
        setDefaultCharset(Charset.forName("utf-8"));
    }
    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = inputMessage.getBody();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(inputStream));

        User user = new User();
        user.setId(Integer.valueOf(properties.getProperty("user.id")));
        user.setName(properties.getProperty("user.name"));

        return user;
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Properties properties = new Properties();
        properties.setProperty("user.id", String.valueOf(user.getId()));
        properties.setProperty("user.name", user.getName());

        properties.store(new OutputStreamWriter(outputMessage.getBody(),getDefaultCharset()), "written by user");
    }
}
