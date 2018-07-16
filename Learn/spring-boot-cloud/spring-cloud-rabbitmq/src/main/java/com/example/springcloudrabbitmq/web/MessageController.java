package com.example.springcloudrabbitmq.web;

import com.example.springcloudrabbitmq.message.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final MessageProducerBean producerBean;

    private final String topic;

    @Autowired
    public MessageController(MessageProducerBean producerBean, @Value("${kafka.topic}") String topic) {
        this.producerBean = producerBean;
        this.topic = topic;
    }

    @PostMapping("/message/send/")
    private void sendCloudMessage(@RequestParam String message) {
        producerBean.sendMessage(message);
    }

    @PostMapping("/selfMessage/send/")
    private void selfSendCloudMessage(@RequestParam String message) {
        producerBean.selfSendMessage(message);
    }
}
