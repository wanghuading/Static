package com.sz.learn.strategy;

/**
 * @Author whd
 * @Date 2018/4/26 22:39
 * @Description 策略模式
 **/
public class StrategyTest {
    public static void main(String[] args) {
        BuildCommunication buildCommunication = new BuildCommunication();
        System.out.println(buildCommunication.choose(new App()));

        System.out.println(buildCommunication.choose(CommunicaEnum.FACE));
    }
}
