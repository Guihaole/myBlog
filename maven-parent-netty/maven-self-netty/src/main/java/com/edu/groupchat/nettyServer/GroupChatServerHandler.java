package com.edu.groupchat.nettyServer;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

//处理器handler
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
    //单例共享
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    //通道建立连接，立即执行它
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[client] " + channel.remoteAddress() + "join chat"
                + sdf.format(new Date()) + "\n");
        channelGroup.add(channel);
    }

    //通道断开连接，执行它
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[client] " + channel.remoteAddress() + "up online\n");
        System.out.println("channel size@ " + channelGroup.size());
    }

    //提示活动上线了
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client " + ctx.channel().remoteAddress() + "on line");
    }

    //提示活动离线了
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client " + ctx.channel().remoteAddress() + "up line");
    }

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel channel = ctx.channel();
        //转发
        channelGroup.forEach(ch -> {
            if (ch != channel) {
                ch.writeAndFlush("[client] " + channel.remoteAddress() + "send message: " + s);
            } else {
                channel.writeAndFlush("[myself] send message: " + s);
            }
        });
    }

    //发生异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
