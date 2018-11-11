package com.sz.rpc.myrmi;

import com.sz.rpc.rmi.service.UserServiceImpl;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyRmiServer {
    ExecutorService executorService =  new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    private ServerSocket newSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    public void register(int port, Object server) throws IOException {
        ServerSocket serverSocket = newSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.execute(() -> {
                try {
                    // 接受客户端消息
                    InputStream is = socket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);
                    RpcRequest rpcRequest = (RpcRequest) ois.readObject();
                    Object result = invoke(rpcRequest, server);


                    // 发送对象实例给客户端
                    OutputStream os = socket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);
                    oos.writeObject(result);
                    oos.flush();

                    oos.close();
                    os.close();
                    ois.close();
                    is.close();
                } catch (IOException | NoSuchMethodException
                        | InvocationTargetException | IllegalAccessException
                        | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            });

        }
    }


    private Object invoke(RpcRequest rpcRequest, Object server) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] types = null;
        if (rpcRequest.getParameters() != null) {
            types = new Class[rpcRequest.getParameters().length];
            Arrays.stream(rpcRequest.getParameters()).map(param -> {
                return param.getClass();
            }).collect(Collectors.toList()).toArray(types);
        }

        Method method = server.getClass().getMethod(rpcRequest.getMethodName(), types);
        return method.invoke(server, rpcRequest.getParameters());
    }
}
