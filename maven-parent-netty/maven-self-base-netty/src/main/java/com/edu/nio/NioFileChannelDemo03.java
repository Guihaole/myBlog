package com.edu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannelDemo03 {
    //把一个文件内容写到另一个文件中去
    public static void main(String[] args) throws Exception  {
        FileInputStream fis = new FileInputStream("E:\\a.txt");
        FileOutputStream fos = new FileOutputStream("E:\\b.txt");
        FileChannel channel01 = fis.getChannel();
        FileChannel channel02 = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        while (true) {
            byteBuffer.clear();
            int read=channel01.read(byteBuffer);
            if(read==-1){
                break;
            }
            byteBuffer.flip();
            channel02.write(byteBuffer);
        }
        fis.close();
        fos.close();
    }
}
