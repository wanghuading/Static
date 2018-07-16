package com.example.springcloudkafka.cloudkafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SelfMessageSource {
    String OUTPUT = "selfout";
    @Output(OUTPUT)
    MessageChannel selfout();
}
