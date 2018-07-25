package com.sz.mybatis.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
)})
public class ExampleInteceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("interceptor");
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        System.out.println("target");
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        System.out.println(properties.getProperty("someProperty"));
    }
}
