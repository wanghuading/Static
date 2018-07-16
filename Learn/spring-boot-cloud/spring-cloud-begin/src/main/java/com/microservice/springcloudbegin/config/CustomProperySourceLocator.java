package com.microservice.springcloudbegin.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Collections;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomProperySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        return new MapPropertySource("my-propertiy",
                Collections.singletonMap("server.port", "9099"));
    }
}
