package com.sz.learn.agent.custom;

import com.sz.learn.agent.Chef;
import com.sz.learn.agent.Person;

/**
 * @Author whd
 * @Date 2018/4/26 20:54
 * @Description
 **/
public class CustomAgentTest {
    public static void main(String[] args) {
        CustomAgent customAgent = new CustomAgent();
        Person person = (Person) customAgent.getInstance(new Chef());
        person.cook();
    }
}
