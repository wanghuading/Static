package com.microservice.springbootexperience.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author whd
 * @Date 2018/6/2 20:52
 * @Description
 **/
@Configuration
public class MultipleDataSourceConfiguration {

    @Bean
    @Primary
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/sampledb")
                .username("root")
                .password("123456")
                .build();
    }

    @Bean
    public DataSource slaveDataSourceOne() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/jeeweb")
                .username("root")
                .password("123456")
                .build();
    }

    @Bean
    public DataSource slaveDataSourceTwo() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/word")
                .username("root")
                .password("123456")
                .build();
    }
}
