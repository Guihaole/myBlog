package com.edu.nio.nioServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

//Nio服务端编写
public class NioServer {
    public static void main(String[] args) throws Exception{
        //创建服务端对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(7777));
        serverSocketChannel.configureBlocking(false);
        //创建一个多路复用器对象
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            //没有事件收发
            if (selector.select(3000)==0) {
                System.out.println("服务器等待3s,无事件发生");
                continue;
            }
            //有事件发生
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                //连接事件
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("有一个客户端连接成功,生成一个socketChannel: "+socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //读事件
                if(key.isReadable()){
                    SocketChannel socketChannel =  (SocketChannel)key.channel();
                    ByteBuffer byteBuffer = (ByteBuffer)key.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println("buffer 客户端："+new String(byteBuffer.array()));
                }
                //手动移除掉这个key
                keyIterator.remove();
            }
        }
    }
}
