package com.edu.netty.nettyClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    //当通道就绪就会触发改方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client ctx: " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello...Server....my name is client", CharsetUtil.UTF_8));
    }

    //通道有读事件发生
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("Server back send message: " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("Server address: " + ctx.channel().remoteAddress());
    }
    //异常处理关闭通道

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
