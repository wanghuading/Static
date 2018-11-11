package com.sz.rpc.myrmi;

import com.sz.rpc.rmi.service.UserServiceImpl;

import java.io.IOException;

public class ServerDemo {
    public static void main(String[] args) {
        MyRmiServer server = new MyRmiServer();
        try {
            server.register(8888, new UserServiceImpl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
