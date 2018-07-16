package com.example.springcloudkafka.bootkafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BootKafkaConsumer {
//    @KafkaListener(topics = "${kafka.topic}")
    public void onMessage(String message) {
        System.err.printf("收到的消息%s", message);
    }
}
