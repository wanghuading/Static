package com.example.springcloudkafka.cloudkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * 流式编程 Spring Cloud 【Programming Model】
 */

@Component
@EnableBinding(Sink.class)
public class MessageConsumerBean {
    @Autowired
    private Sink sink;
    @Autowired
    @Qualifier(Sink.INPUT)
    SubscribableChannel subscribableChannel;

//    @PostConstruct
    public void init() {
        subscribableChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("postConstrust订阅的消息"+message.getPayload());
            }
        });
    }

//    @ServiceActivator(inputChannel = Sink.INPUT)
    public void onMessage(Object message) {
        System.out.printf("ServiceActivator 接收到的消息%s",message);
    }

    @StreamListener(Sink.INPUT)
    public void onStreamMessage(Object message) {
        System.out.printf("StreamListener接收到的消息%s", message);
    }
}
