package com.edu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NioFileChannelCopy04 {
    //copy一个二进制文件
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("E:\\th2.jpg");
        FileOutputStream fos = new FileOutputStream("E:\\th.jpg");
        FileChannel channel01 = fis.getChannel();
        FileChannel channel02 = fos.getChannel();
        channel02.transferFrom(channel01,0,channel01.size());
        channel01.close();
        channel02.close();
        fis.close();
        fos.close();
    }
}
