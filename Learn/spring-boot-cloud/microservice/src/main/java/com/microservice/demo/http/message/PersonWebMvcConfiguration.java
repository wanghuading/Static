package com.microservice.demo.http.message;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Author whd
 * @Date 2018/5/30 14:17
 * @Description
 **/
//@Configuration
public class PersonWebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new PersonPropertiesHttpMessageConverter());
    }
}
