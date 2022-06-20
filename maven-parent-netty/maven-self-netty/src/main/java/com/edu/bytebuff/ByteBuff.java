package com.edu.bytebuff;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

//nett提供的缓冲区
public class ByteBuff {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("hello wold!",Charset.forName("utf-8"));
        if (buf.hasArray()) {
            byte[] bytes = buf.array();
            System.out.println(new String(bytes,Charset.forName("utf-8")));
            System.out.println("byteBuf = :"+buf);
            System.out.println("readIndex@ "+buf.readerIndex());
            System.out.println("readIndex@ "+buf.writerIndex());
            System.out.println("cap@ "+buf.capacity());
            System.out.println("0 ~ 4(length)@ "+buf.getCharSequence(0,4,Charset.forName("utf-8")));
        }

    }
    //buffer()
    public static void buf(){
        ByteBuf buf = Unpooled.buffer(10);
        for (int i = 0; i < buf.capacity(); i++) {
            buf.writeByte(i);
        }
        System.out.println("cap = "+buf.capacity());
        for (int i = 0; i < buf.capacity(); i++) {
            System.out.print(buf.readByte());
        }
    }
}
