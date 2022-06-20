package com.edu.inandoutHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
//编码
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long aLong, ByteBuf byteBuf) throws Exception {
        System.out.println("MyLongToByteEncoder encode invoke.......");
        System.out.println("msg=" + aLong);
        ctx.writeAndFlush(aLong);
    }
}
