package com.microservice.springcloudstream.web;

import com.microservice.springcloudstream.SpringCloudStreamApplication;
import com.microservice.springcloudstream.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;


//@EnableBinding(Source.class)
@RestController
public class Message {
    @Autowired
    private Source source;

    /*@Autowired
    @Qualifier("timeMessageSource")
    private MessageSource messageSource;*/

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody Person person) {
        source.output().send(MessageBuilder.withPayload(person).build());
    }
}
