package com.microservice.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author whd
 * @Date 2018/5/30 23:36
 * @Description
 **/
public class DefaultHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println();
        System.out.printf("interceptor = %s", request.getRequestURI());
        System.out.println();
        return true;
    }
}
