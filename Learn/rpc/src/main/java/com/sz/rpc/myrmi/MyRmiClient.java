package com.sz.rpc.myrmi;

import com.sz.rpc.rmi.service.UserService;

import java.io.*;
import java.net.Socket;

public class MyRmiClient {

    private Socket newSocket(String host, int port) throws IOException {
        return new Socket(host, port);
    }

    public Object lookup(String host, int port, RpcRequest rpcRequest) throws IOException, ClassNotFoundException {
        Socket socket = newSocket(host,port);
        // 发送消息给服务端
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(rpcRequest);
        oos.flush();

        // 接受调用对象实例
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        Object obj = ois.readObject();
        ois.close();
        is.close();
        socket.close();
        return obj;
    }
}
