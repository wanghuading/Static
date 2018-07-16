package com.microservice.springcloudstream.Source;

import com.microservice.springcloudstream.entity.Person;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

//@EnableBinding(Sink.class)
public class HanderErrorSource {
    @StreamListener(Sink.INPUT) // destination name 'input.myGroup'
    public void handle(Person value){
        System.out.printf("收到的消息%s",value.getName());
	    throw new RuntimeException("BOOM!");
    }

   /* @ServiceActivator(inputChannel = "test.myGroup.errors") //channel name 'input.myGroup.errors'
    public void error(Message<?> message) {
        System.out.println("Handling ERROR: " + message);
    }*/

    @StreamListener("errorChannel")
    public void globalError(Message<?> message) {
        System.out.println("Handling ERROR: " + message);
    }
}
