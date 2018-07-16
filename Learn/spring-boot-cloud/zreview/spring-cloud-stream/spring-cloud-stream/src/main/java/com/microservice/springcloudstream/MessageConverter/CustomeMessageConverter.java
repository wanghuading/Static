package com.microservice.springcloudstream.MessageConverter;

import com.microservice.springcloudstream.entity.Person;
import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

import java.nio.charset.Charset;


public class CustomeMessageConverter extends AbstractMessageConverter {
    public CustomeMessageConverter() {
        super(new MimeType("application", "bar",Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return Person.class.getName().equals(aClass.getName());
    }

    @Override
    public Object convertFromInternal(Message<?> message, Class<?> targetClass,
                                      @Nullable Object conversionHint) {
        Object payload = message.getPayload();
        return payload instanceof Person ? payload : new Person((byte[]) payload);
    }

    @Override
    public Object convertToInternal(Object payload, @Nullable MessageHeaders headers, @Nullable Object conversionHint) {
        System.out.printf("llll");
        return null;
    }
}
