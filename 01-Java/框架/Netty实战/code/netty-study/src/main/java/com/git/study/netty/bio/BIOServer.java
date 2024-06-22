package com.git.study.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池 一个连接分配一个线程
 * 演示阻塞IO
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Server started!!!");

        while (true) {

            final Socket socket = serverSocket.accept();
            System.out.println("Client is connected!!!");
            executorService.execute(() -> {
                try {
                    handler(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }

    private static void handler(Socket socket) throws IOException {

        byte[] bytes = new byte[1024];
        InputStream is = null;
        try {

            System.out.println("Handler Thread is " + Thread.currentThread().getId());
            is = socket.getInputStream();
            int read = -1;
            while ((read = is.read(bytes)) != -1) {
                System.out.println(new java.lang.String(bytes, 0, read));
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            socket.close();
            System.out.println("Connetion is closed!!!");
        }
    }


}
