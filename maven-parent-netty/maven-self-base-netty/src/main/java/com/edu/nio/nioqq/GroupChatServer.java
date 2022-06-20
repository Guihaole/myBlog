package com.edu.nio.nioqq;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {
    //定义属性
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final Integer port = 6667;

    //构造初始化
    public GroupChatServer() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //监听
    public void listen() {
        try {
            while (true) {
                int select = selector.select();
                //有收发事件
                if (select > 0) {
                    Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress() + "shang xian le");
                        }
                        if (key.isReadable()) {
                            //读数据
                            readData(key);
                        }
                        keyIterator.remove();
                    }
                } else {
                    System.out.println("wait ............ waiting");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //发生异常处理
        }
    }

    //读取客户端消息
    private void readData(SelectionKey key) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(buffer);
            if (read > 0) {
                String msg = new String(buffer.array());
                System.out.println("from client: " + msg);
                //转发给其他人
                sendInfoToOtherClients(msg,socketChannel);
            }
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + " go online");
                //取消注册
                key.cancel();
                socketChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //转发给其他人
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws Exception {
        System.out.println("forward messages ing.....");
        for (SelectionKey key : selector.keys()) {
            SelectableChannel targetChannel = key.channel();
            //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel socketChannel = (SocketChannel) targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                socketChannel.write(buffer);
            }
        }
    }

    public static void main(String[] args) {
        //创建服务端对象
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
