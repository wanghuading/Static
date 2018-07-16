package com.microservice.springcloudbegin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private final Environment environment;

    @Autowired
    public EnvController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/getEnv/{var}/")
    public Map<String, Object> getEnvVariate(@PathVariable String var) {
        Map<String, Object> vars = new HashMap<>();
        vars.put(var, environment.getProperty(var));
        return vars;
    }

    @GetMapping("/getAllEnv")
    public Environment getAllEnv() {
        return environment;
    }
}
