package com.microservice.userprovider.repository;

import com.microservice.userapi.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {
    private AtomicInteger id = new AtomicInteger(0);
    private ConcurrentSkipListSet<User> users = new ConcurrentSkipListSet();
    public boolean save(User user) {
        user.setId(id.incrementAndGet());
        return users.add(user);
    }

    public Collection<User> findAll() {
        return users;
    }
}
