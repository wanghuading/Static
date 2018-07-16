package com.microservice.userprovider.service;

import com.microservice.userapi.domain.User;
import com.microservice.userprovider.repository.UserRepository;
import com.microservice.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
