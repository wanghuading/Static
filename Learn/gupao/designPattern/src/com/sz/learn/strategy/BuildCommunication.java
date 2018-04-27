package com.sz.learn.strategy;

/**
 * @Author whd
 * @Date 2018/4/26 22:48
 * @Description
 **/
public class BuildCommunication {
    public String choose(Communication communication){
        communication.talk();
        return "沟通完毕";
    }
    public String choose(CommunicaEnum type) {
        return choose(type.get());
    }
}
