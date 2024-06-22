package com.git.study.netty.nio.cs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress localhost = new InetSocketAddress("localhost", 6666);

        if (!socketChannel.connect(localhost)) {

            while (!socketChannel.finishConnect()) {
                System.out.println("connection is connecting,do something else...");
            }
            System.out.println("Server is connected ...");
        }
        System.out.println("Sending message...");
        ByteBuffer buffer = ByteBuffer.wrap("hello world".getBytes());
        socketChannel.write(buffer);
        System.in.read();
        socketChannel.close();
    }
}
