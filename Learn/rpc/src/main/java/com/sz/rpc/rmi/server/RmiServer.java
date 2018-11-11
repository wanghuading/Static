package com.sz.rpc.rmi.server;

import com.sz.rpc.rmi.service.UserService;
import com.sz.rpc.rmi.service.UserServiceImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    public static void main(String[] args) {
        try {
            // 创建代理对象-> 创建客户端接入监听
            UserService userService = new UserServiceImpl();
            System.out.println(userService.getUser());
            // 创建registry代理对象
            LocateRegistry.createRegistry(8888);
            Naming.rebind("rmi://127.0.0.1:8888/userService", userService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
