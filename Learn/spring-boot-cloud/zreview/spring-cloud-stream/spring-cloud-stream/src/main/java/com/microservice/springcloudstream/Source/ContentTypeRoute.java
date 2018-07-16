package com.microservice.springcloudstream.Source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

//@EnableBinding(Sink.class)
public class ContentTypeRoute {

    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'dog'")
    private void handlerDog(String message) {
        System.out.printf("处理Dog消息,%s",message);
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'cat'")
    public void handlerCat(String message) {
        System.out.printf("处理cat消息%s", message);
    }
}
