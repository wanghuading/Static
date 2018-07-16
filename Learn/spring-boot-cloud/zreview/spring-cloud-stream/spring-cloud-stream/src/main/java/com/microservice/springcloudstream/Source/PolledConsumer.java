package com.microservice.springcloudstream.Source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.MessageChannel;

public interface PolledConsumer {
    @Input("destIn")
    PollableMessageSource destIn();

    @Output("destOut")
    MessageChannel destOut();
}
