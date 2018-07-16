package com.microservice.personserver.web;

import com.microservice.personapi.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
// 可以不实现PersonService接口
public class PersonServerController /*implements PersonService*/ {
    Map<Integer, Person> map = new HashMap<>();
    Random random = new Random(200);
    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person) {
        return map.put(person.getId(), person) == null;
    }

    @GetMapping("/person/find/all")
    @HystrixCommand(fallbackMethod = "errorMethod",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "100")
        }
    )
    public Collection<Person> findAll() {

        int val = random.nextInt(200);
        try {
            System.out.println("sleep"+val);
            Thread.sleep(val);
            System.out.println("make it");
        } catch (InterruptedException e) {

        }
        return map.values();
    }

    private Collection<Person> errorMethod() {
        System.out.println("error");
        return Collections.emptyList();
    }
}
