package com.edu.nio;


import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannelDemo02 {
    public static void main(String[] args) throws Exception {
        //写数据到本地文件
        String str = "hello,word netty,我来学习啦";
        File file = new File("E:\\a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream("E:\\a.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(50);
        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        channel.write(byteBuffer);
        fos.close();
    }
}
