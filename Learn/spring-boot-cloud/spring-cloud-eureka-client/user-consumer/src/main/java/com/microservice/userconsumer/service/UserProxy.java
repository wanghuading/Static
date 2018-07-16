package com.microservice.userconsumer.service;

import com.microservice.userapi.domain.User;
import com.microservice.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Service
public class UserProxy implements UserService {
    private final String USER_PROVIDER_NAME = "http://eureka-user-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean save(User user) {
        restTemplate.postForObject(USER_PROVIDER_NAME+"/user/save", user, User.class);
        return true;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) restTemplate
                .getForObject(USER_PROVIDER_NAME+"/user/findAll",Collection.class);
    }
}
