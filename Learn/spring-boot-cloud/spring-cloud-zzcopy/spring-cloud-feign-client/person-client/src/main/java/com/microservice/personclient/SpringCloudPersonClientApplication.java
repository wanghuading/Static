package com.microservice.personclient;

import com.microservice.personapi.service.PersonService;
import com.microservice.personclient.ribbon.MyRule;
import com.microservice.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients=PersonService.class)
@EnableHystrix
@Import(WebConfig.class)
/**
 * 添加这个配置会报错，跟咕泡老师讲的不一致
    @RibbonClient(value = "person-server",
        configuration = SpringCloudPersonClientApplication.class)*/
public class SpringCloudPersonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPersonClientApplication.class, args);
    }

    /*@Bean
    public MyRule myRule() {
        return new MyRule();
    }*/
}
