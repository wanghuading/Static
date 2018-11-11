package com.sz.rpc.rmi.service;

import com.sz.rpc.rmi.entity.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public User getUser2() throws RemoteException {
        User user = new User();
        user.setId(2);
        user.setName("whd2");
        return user;
    }

    public User getUser() throws RemoteException {
        User user = new User();
        user.setId(1);
        user.setName("whd");
        return user;
    }
}
