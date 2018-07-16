package com.microservice.springcloudconfigclient.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class EchoServerConfigController {

    @Value("${my.name}")
    private String myName;

    @GetMapping("/getMyName")
    public String getMyName() {
        return myName;
    }
}
