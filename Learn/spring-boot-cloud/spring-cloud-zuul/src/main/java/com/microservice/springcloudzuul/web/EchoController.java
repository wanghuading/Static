package com.microservice.springcloudzuul.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
//    @Value("${zuul.routes.person-server}")
    private String server;

//    @Value("${zuul.routes.person-client}")
    private String client;
    @Value("${my.name}")
    private String myName;

    @RequestMapping("/getConfig")
    public String getConfig() {
        return myName;
    }
}
