package com.edu.netty.nettyClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


//netty客户端编写
public class NettyClient {
    public static void main(String[] args) {
        //1.创建线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //2.创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();
            //3.配置客户端启动配置
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("Client is read......");
            //4.连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8081);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //5.优雅的关闭资源
            group.shutdownGracefully();
        }
    }
}
