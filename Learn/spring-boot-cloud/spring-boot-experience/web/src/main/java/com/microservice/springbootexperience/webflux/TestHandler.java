package com.microservice.springbootexperience.webflux;

import com.microservice.springbootexperience.pojo.TestUser;
import com.microservice.springbootexperience.repository.TestRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author whd
 * @Date 2018/6/2 17:36
 * @Description
 **/
@Component
public class TestHandler {
    private TestRepository testRepository;

    public TestHandler(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        // Mono<Test>类似于Optional<User>
        System.out.printf("handler Current Thread Name %s", Thread.currentThread().getName());
        Mono<TestUser> testMono = serverRequest.bodyToMono(TestUser.class);
        Mono<Boolean> booleanMono = testMono.map(testRepository::save);
        return ServerResponse.ok().body(booleanMono, Boolean.class);
    }
}
