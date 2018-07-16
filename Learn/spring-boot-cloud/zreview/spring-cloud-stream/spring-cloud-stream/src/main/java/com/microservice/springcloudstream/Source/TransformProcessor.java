package com.microservice.springcloudstream.Source;

import com.microservice.springcloudstream.entity.Person;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.io.ObjectInputStream;

//@EnableBinding(Processor.class)
public class TransformProcessor {
//    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Object message) {
        System.out.printf("收到的消息%s",message);
        return message;
    }

//    @StreamListener(Processor.INPUT)
    public void message(Person person) {
        System.out.printf("person.id:%s,person.name:%s", person.getId(), person.getName());
    }
}
