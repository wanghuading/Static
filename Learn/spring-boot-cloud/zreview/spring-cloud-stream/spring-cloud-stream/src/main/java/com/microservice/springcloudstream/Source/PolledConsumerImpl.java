package com.microservice.springcloudstream.Source;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

//@EnableBinding(PolledConsumer.class)
public class PolledConsumerImpl {
    @Bean
    public ApplicationRunner poller(PollableMessageSource destIn,
                                    MessageChannel destOut) {
        return args -> {
            while (true) {
                try {
                    if (!destIn.poll(m -> {
                        System.out.printf("取得的消息为%s",m.getPayload());
                        String newPayload = ((String) m.getPayload()).toUpperCase();
                        destOut.send(new GenericMessage<>(newPayload));
                    })) {
                        Thread.sleep(1000);
                    }
                }
                catch (Exception e) {
                    // handle failure (throw an exception to reject the message);
                }
            }
        };
    }
}
