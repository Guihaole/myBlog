package com.edu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

//多缓冲使用  client-->arr[byteBuffer]--->socketChannel
public class NioByteBufferArrDemo {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7777);
        serverSocketChannel.socket().bind(inetSocketAddress);
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        //等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        int maxLength = 8;
        while (true) {
            long countRead = 0;
            while (countRead < maxLength) {
                long l=socketChannel.read(byteBuffers);
                countRead += l;
                System.out.println("countRead: " + countRead);
                //打印缓冲区
                Arrays.asList(byteBuffers).stream().map(buffer -> "position = " + buffer.position() + "@limit = " + buffer.limit())
                        .forEach(System.out::print);
            }
            //将说有地buffer逆转
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());
            long countWrite = 0;
            while (countWrite < maxLength) {
                long l = socketChannel.write(byteBuffers);
                countWrite += l;
            }
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());
            System.out.println("countRead = " + countRead + "@countWrite = " + countWrite + "@maxLength = " + maxLength);
        }

    }
}
