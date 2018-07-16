package com.microservice.excetion;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.microservice.controller")
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {NullPointerException.class})
    public String handlderNpe(NullPointerException ex) {
        System.out.printf("exception message: %s",ex.fillInStackTrace());
        return "Null Point Exception";
    }
}
