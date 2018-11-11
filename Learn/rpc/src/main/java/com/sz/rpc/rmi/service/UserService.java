package com.sz.rpc.rmi.service;

import com.sz.rpc.rmi.entity.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    User getUser() throws RemoteException;
    User getUser2() throws RemoteException;
}
