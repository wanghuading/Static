package com.microservice.personapi.service.fallback;

import com.microservice.personapi.domain.Person;
import com.microservice.personapi.service.PersonService;

import java.util.Collection;
import java.util.Collections;

public class PersonServiceFallback implements PersonService {
    @Override
    public boolean save(Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        System.out.println("----");
        return Collections.EMPTY_LIST;
    }
}
