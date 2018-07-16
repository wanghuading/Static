package com.microservice.feign;

import com.microservice.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@FeignClient(value = "${web-server}",
//        fallback = UserServiceFallback.class,
        // 可以访问失败的原因
        fallbackFactory = UseServiceFallbackFactory.class
)
public interface UserService {
    @PostMapping("/user/add")
    public boolean save(User user);
    @GetMapping("/user/find/all")
    public Collection<User> findAll();
}
