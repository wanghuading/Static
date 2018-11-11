package com.sz.service;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("120.79.68.205:2181");
        List<String> children = zkClient.getChildren("/zookeeper");
        System.out.println(children.size());
    }
}
