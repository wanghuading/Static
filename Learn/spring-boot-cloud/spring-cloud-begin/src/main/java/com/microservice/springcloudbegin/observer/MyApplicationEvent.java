package com.microservice.springcloudbegin.observer;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {
    public MyApplicationEvent(Object source) {
        super(source);
    }
}
