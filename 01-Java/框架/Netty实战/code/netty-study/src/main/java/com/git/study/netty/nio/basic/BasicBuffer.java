package com.git.study.netty.nio.basic;

import com.git.study.netty.constant.Constant;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class BasicBuffer {
    /**
     * 直接在堆外内存修改数据
     */
    @Test
    public void testMappedBuffer() throws Exception {
        RandomAccessFile ra = new RandomAccessFile(Constant.TEXT_DESTINATION, "rw");
        FileChannel channel = ra.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'E');
        mappedByteBuffer.put(4, (byte) '0');
    }

    /**
     * 利用通道复制bufferAPI进行文件拷贝
     */
    @Test
    public void testCopyAPI() throws IOException {


        try (FileOutputStream fo = new FileOutputStream(Constant.IMAGE_DESTINATION);
             FileInputStream fi = new FileInputStream(Constant.IMAGE_SOURCE);
             FileChannel foChannel = fo.getChannel();
             FileChannel fiChannel = fi.getChannel()) {

            foChannel.transferFrom(fiChannel, 0, fiChannel.size());

        }
    }

    /**
     * 测试文件拷贝,重点在于 buffer的处理,需要复位
     */
    @Test
    public void testCopy() throws IOException {

        FileChannel fiChannel;
        FileChannel foChannel;
        try (FileInputStream fi = new FileInputStream(Constant.TEXT_SOURCE);
             FileOutputStream fo = new FileOutputStream(Constant.TEXT_DESTINATION, true)) {
            fiChannel = fi.getChannel();
            foChannel = fo.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(128);
            while (true) {
                buffer.clear();
                if (fiChannel.read(buffer) == -1) break;
                buffer.flip();
                foChannel.write(buffer);
            }
        }


    }

    /**
     * 测试 文件输入
     *
     * @throws IOException
     */
    @Test
    public void testFileChannelInput() throws IOException {

        FileInputStream fi = new FileInputStream(Constant.TEXT_SOURCE);
        FileChannel fiChannel = fi.getChannel();
        ByteBuffer dest = ByteBuffer.allocate(1024);
        fiChannel.read(dest);
        System.out.println(new String(dest.array()));

        fi.close();

    }

    /**
     * 测试 文件输入
     *
     * @throws IOException
     */
    @Test
    public void testFileChannelOutput() throws IOException {

        FileOutputStream fo = new FileOutputStream(Constant.TEXT_DESTINATION);
        FileChannel foChannel = fo.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(Constant.DATA.getBytes());
        buffer.flip();
        foChannel.write(buffer);
        fo.close();
    }

    /**
     * buffer 的 get 和 put 使用
     */
    @Test
    public void testBuffer() {

        IntBuffer buffer = IntBuffer.allocate(5);
        for (int i = 0; i < 5; i++) {
            buffer.put(i * i);
        }

        buffer.flip();

        for (int i = 0; i < 5; i++) {
            System.out.println(buffer.get());
        }
    }
}
