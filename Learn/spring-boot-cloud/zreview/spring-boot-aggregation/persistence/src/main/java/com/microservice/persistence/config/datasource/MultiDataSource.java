package com.microservice.persistence.config.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MultiDataSource {
    @Bean
    public DataSource slaveDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/jeeweb" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                        "&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .username("root")
                .password("123456")
                .build();
        return dataSource;
    }

    @Bean
    @Primary
    public DataSource primaryDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        DataSource doSource = dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/sampledb" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                        "&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .username("root")
                .password("123456")
                .build();
        return doSource;
    }
}
