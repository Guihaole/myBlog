package com.edu.inandoutHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    //添加handler
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //出栈过程
        //解码器
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new MyByteToLongDecoder());
        //业务逻辑
        pipeline.addLast(new MyServerHandler());
    }
}
