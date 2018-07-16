package com.microservice.personclient.web;

import com.microservice.personapi.domain.Person;
import com.microservice.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
// 可以不实现PersonService接口
public class PersonClientController /*implements PersonService*/{
    private final PersonService personService;
    @Autowired
    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/person/find/all")
    public Collection<Person> findAll() {
         return personService.findAll();
    }
}
