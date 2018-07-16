package com.microservice.personclient;

import com.microservice.personapi.service.PersonService;
import com.microservice.personclient.ribbon.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients=PersonService.class)
@EnableHystrix
/**
 * 添加这个配置会报错，跟咕泡老师讲的不一致
    @RibbonClient(value = "person-server",
        configuration = SpringCloudPersonClientApplication.class)*/
public class SpringCloudPersonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPersonClientApplication.class, args);
    }

    @Bean
    public MyRule myRule() {
        return new MyRule();
    }
}
