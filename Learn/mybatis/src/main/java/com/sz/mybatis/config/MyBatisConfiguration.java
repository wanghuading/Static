package com.sz.mybatis.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sz.mybatis.domain.TestMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class MyBatisConfiguration {
    public static Configuration getConfiguration() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("simpledb");
        dataSource.setURL("jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",
                transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(TestMapper.class);
        return configuration;
    }
}
