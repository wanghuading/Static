package com.sz.mybatis;

import com.ibatis.common.resources.Resources;
import com.sz.mybatis.config.MyBatisConfiguration;
import com.sz.mybatis.domain.Test;
import com.sz.mybatis.domain.TestMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mybatis {
    public static void main(String[] args) {
//        mybatisJavaConfig();
        mybatisXml();
    }

    private static void mybatisJavaConfig() {
        SqlSession sqlSession = null;
        try {
            // 从配置类加载
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(MyBatisConfiguration.getConfiguration());
            sqlSession = sqlSessionFactory.openSession();
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            Test test = testMapper.selectBlog(34);
            System.out.println(test.getId()+"--->"+test.getName());
        } catch (Exception e) {
            sqlSession.close();
        }
    }

    private static void mybatisXml() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            /*
            // 通过方法加载属性
            Properties properties = new Properties();
            InputStream pis = new FileInputStream("D:\\Source\\learn\\code\\GitHub\\Static\\Learn\\mybatis\\src\\main\\resources\\properties\\mybatis.properties");
            properties.load(pis);*/
            // 从配置文件加载
            inputStream = Resources.getResourceAsStream(resource);
            Reader reader = new BufferedReader(new InputStreamReader(inputStream));
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader, "development_1");
            sqlSession = sqlSessionFactory.openSession();
//            Map<String, Object> params = new HashMap<String, Object>();
//            params.put("name", "test23");
//            params.put("id",34);
//            sqlSession.update("com.sz.mybatis.domain.Test.updateTest", params);
            sqlSession.insert("com.sz.mybatis.domain.Test.insertTest", "oo-ll");
            sqlSession.commit();

            /*Test test = sqlSession
                    .selectOne("com.sz.mybatis.domain.Test.selectTest", 34);
            System.out.println(test.getId()+"--->"+test.getName());*/
        } catch (Exception e) {
            sqlSession.close();
            e.printStackTrace();
        }
    }
}
