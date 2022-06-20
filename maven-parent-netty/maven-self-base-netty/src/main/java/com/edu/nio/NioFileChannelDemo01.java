package com.edu.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//Nio中的channel组件
public class NioFileChannelDemo01 {
    //读取文件
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("E:\\mavenoffcnidea-work\\maven-parent-netty\\maven-self-base-netty\\1.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        fis.close();
    }

}
