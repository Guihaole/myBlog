package com.edu.inandoutHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

//编码 入栈顺序 pipe的尾部为起点
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //编码
        pipeline.addLast(new MyLongToByteEncoder());
        //业务逻辑
        pipeline.addLast(new MyClientHandler());
    }
}
