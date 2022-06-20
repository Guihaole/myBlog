package com.edu.nio;

import java.nio.ByteBuffer;

//buffer的数据存取细节
public class NioByteBufferPutGet {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(50);
        byteBuffer.putInt(1);
        byteBuffer.putChar('归');
        byteBuffer.putFloat(4l);
        byteBuffer.putDouble(0.2);
        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getDouble());
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
    }
}
