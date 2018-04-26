package com.sz.learn.agent.statics;

import com.sz.learn.agent.Agented;

/**
 * @Author whd
 * @Date 2018/4/26 10:09
 * @Description
 **/
public class StaticsAgentTest {
    public static void main(String[] args) {
        StaticsAgent staticsAgent = new StaticsAgent(new Agented());
        staticsAgent.cook();
    }
}
