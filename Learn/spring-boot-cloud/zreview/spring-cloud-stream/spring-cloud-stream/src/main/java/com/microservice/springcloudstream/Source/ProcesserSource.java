package com.microservice.springcloudstream.Source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

//@EnableBinding(Processor.class)
public class ProcesserSource {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String handle(String value) {
        System.out.printf("Received Msg:%s",value);
        return value.toUpperCase();
    }
}
