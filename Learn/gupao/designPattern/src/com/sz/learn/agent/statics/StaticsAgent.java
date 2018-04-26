package com.sz.learn.agent.statics;

import com.sz.learn.agent.Agented;

/**
 * @Author whd
 * @Date 2018/4/26 10:05
 * @Description 静态代理类
 **/
public class StaticsAgent {
    private Agented agented;
    public StaticsAgent(Agented agented) {
        this.agented = agented;
    }
    public void cook() {
        System.out.println("我去买菜");
        agented.cook();
        System.out.println("我收拾碗筷");
    }
}
