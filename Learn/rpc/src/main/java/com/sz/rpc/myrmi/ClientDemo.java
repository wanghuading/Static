package com.sz.rpc.myrmi;

import com.sz.rpc.rmi.service.UserService;

import java.io.IOException;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            UserService userService = new MyRmiClientProxy().clientProxy(UserService.class,"127.0.0.1", 8888);
            System.out.println(userService.getUser().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
