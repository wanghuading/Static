package com.microservice.personserver.web;

import com.microservice.personapi.domain.Person;
import com.microservice.personapi.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
// 可以不实现PersonService接口
public class PersonServerController /*implements PersonService*/ {
    Map<Integer, Person> map = new HashMap<>();

    @PostMapping("/person/save")
    public boolean save1(@RequestBody Person person) {
        return map.put(person.getId(), person) == null;
    }

    @PostMapping("/person/save2")
    public boolean save2(@RequestBody Person person) {
        return map.put(person.getId(), person) == null;
    }

    @GetMapping("/person/find/all")
    public Collection<Person> findAll() {
        return map.values();
    }
}
