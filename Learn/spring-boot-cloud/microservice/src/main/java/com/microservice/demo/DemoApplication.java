package com.microservice.demo;

import com.microservice.demo.filter.DefaultFilter;
import com.microservice.demo.interceptor.DefaultHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication extends WebMvcConfigurerAdapter implements ErrorPageRegistrar {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefaultHandlerInterceptor());
    }

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
//        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
    }

    @Bean
    public DefaultFilter defaultFilter() {
	    return new DefaultFilter();
    }
}
