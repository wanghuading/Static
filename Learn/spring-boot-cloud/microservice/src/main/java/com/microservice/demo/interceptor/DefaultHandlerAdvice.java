package com.microservice.demo.interceptor;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author whd
 * @Date 2018/5/31 18:13
 * @Description
 **/
//@RestControllerAdvice("com.microservice.demo.Controller")
public class DefaultHandlerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public Object handlerNpe(Throwable throwable) {
        Map<String, Object> data = new HashMap<>();
        data.put("message", throwable.getMessage());
        return data;
    }
}
