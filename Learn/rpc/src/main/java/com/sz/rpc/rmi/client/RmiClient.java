package com.sz.rpc.rmi.client;

import com.sz.rpc.rmi.service.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClient {
    public static void main(String[] args) {
        try {
            UserService userService = (UserService) Naming
                    .lookup("rmi://127.0.0.1:8888/userService");
            System.out.println(userService.getUser());
            System.out.println(userService.getUser().getName());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
