package com.microservice.controller;

import com.microservice.persistence.model.User;
import com.microservice.persistence.repository.UserRepository;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRepository userRepository;

    @HystrixCommand(
        fallbackMethod = "findAllFallback",
        commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")
        }
    )
    @GetMapping("/user/find/all")
    public Collection<User> findAll() {
        Random random = new Random();
        int randVal = random.nextInt(200);
        try {
            System.out.printf("随机值为%s",randVal);
            Thread.sleep(randVal);
        } catch (InterruptedException e) {
            System.out.printf("超时中断。。。");
//            e.printStackTrace();
        }
        logger.info("web-server(findall)链路");
        return userRepository.findAll();
    }

    /**
     *  错误回调方法，返回值必须与正常执行调用的方法一致{@link UserController#findAll()}
     * @return
     */
    public Collection<User> findAllFallback() {
        System.out.printf("调用超时");
        return Collections.emptyList();
    }

    @PostMapping("/user/add")
    public boolean add(@RequestBody User user) {
        logger.info("web-server(add)链路");
        return userRepository.save(user);
    }

    @PostMapping(value = "/user/addToProperties",
        consumes = "application/properties+user",// 接收类型
        produces = "application/properties+user" // 响应类型
    )
    public User addToProperties(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @PostMapping("/user/addTra")
    public boolean addTra(@Validated @RequestBody User user) {
        return userRepository.transactionSave(user);
    }
    @PostMapping("/user/addPlatform")
    public boolean addPlatform(@RequestBody User user) {
        return userRepository.platformSave(user);
    }

    @PostMapping("/user/addToError")
    public boolean addToError(@RequestBody User user) {
        user = null;
        // 需在vm option参数中加入-ea
//        assert user != null;
        // spring自带断言，自动启用
//        Assert.notNull(user, "用户不能为空");
        user.setName("111");
        return false;
    }


    @GetMapping("/user/npe")
    public void npe() {
        User user = null;
        System.out.println(user.getName());
    }

    @GetMapping("/404")
    public String notFound() {
        return "not found";
    }
}
