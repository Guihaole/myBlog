package com.edu.nio.nioqq;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

//群聊客户端
public class GroupChatClient {
    private static final String IP = "127.0.0.1";
    private static final Integer PORT = 6667;
    private SocketChannel socketChannel;
    private Selector selector;
    private String username;

    //初始化
    public GroupChatClient() throws Exception {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(IP, PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username + "is ok....");
    }

    //向服务器发送数据
    public void sendInfo(String info) {
        info = username + "@say：" + info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //接收服务端数据
    public void readInfo() {
        try {
            int readChannels = selector.select();
            if (readChannels > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.read(buffer);
                        System.out.println(new String(buffer.array()).trim());
                    }
                    iterator.remove();
                }
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        GroupChatClient groupChatClient = new GroupChatClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    groupChatClient.readInfo();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //发数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            groupChatClient.sendInfo(s);
        }
    }
}
