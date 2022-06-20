package com.edu.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

//Nio中buffer组件
public class BufferNio {
    public static void main(String[] args) throws Exception {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }
        //重新将缓冲的变量重置 mark,pos,cap,limit
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
