package com.edu.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    //数据是以帧方式传输 frame
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("websocket receive message: " + textWebSocketFrame.text());
        //回复客户端消息
        channel.writeAndFlush(new TextWebSocketFrame("server nowTime :" +
                LocalDateTime.now() + ": " + textWebSocketFrame.text()));
    }

    //连接就调用
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded invoked" + ctx.channel().id().asLongText());
        System.out.println("handlerAdded invoked" + ctx.channel().id().asShortText());
    }

    //断开即调用
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded invoked" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
