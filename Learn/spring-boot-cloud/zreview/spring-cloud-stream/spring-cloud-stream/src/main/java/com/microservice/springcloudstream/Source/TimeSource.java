package com.microservice.springcloudstream.Source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

//@EnableBinding(Source.class)
public class TimeSource {

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,
            poller = {@Poller(fixedDelay = "10",maxMessagesPerPoll = "1")})
    public MessageSource<String> timeMessageSource() {
        return () -> new GenericMessage<String>("Hello Spring Cloud Stream");
    }
}
