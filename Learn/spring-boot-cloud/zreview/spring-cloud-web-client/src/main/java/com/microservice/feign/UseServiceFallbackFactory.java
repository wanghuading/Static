package com.microservice.feign;

import com.microservice.model.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class UseServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public boolean save(User user) {
                System.out.printf("The fallback reason is %s",throwable.getMessage());
                return false;
            }

            @Override
            public Collection<User> findAll() {
                    System.out.printf("The fallback reason is %s",
                            throwable.getMessage());
                return Collections.emptyList();
            }
        };
    }
}
