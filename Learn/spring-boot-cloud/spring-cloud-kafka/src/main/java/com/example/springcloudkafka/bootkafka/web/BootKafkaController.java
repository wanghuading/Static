package com.example.springcloudkafka.bootkafka.web;

import com.example.springcloudkafka.cloudkafka.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootKafkaController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageProducerBean producerBean;

    private final String topic;

    @Autowired
    public BootKafkaController(KafkaTemplate<String, String> kafkaTemplate,
                               MessageProducerBean producerBean, @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.producerBean = producerBean;
        this.topic = topic;
    }

    @PostMapping("/bootKafka/send/")
    private void sendMessage(@RequestParam String message) {
        kafkaTemplate.send(topic, message);
    }

    @PostMapping("/cloudKafka/send/")
    private void sendCloudMessage(@RequestParam String message) {
        producerBean.sendMessage(message);
    }

    @PostMapping("/selfCloudKafka/send/")
    private void selfSendCloudMessage(@RequestParam String message) {
        producerBean.selfSendMessage(message);
    }
}
