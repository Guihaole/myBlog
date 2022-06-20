package com.edu.netty.nettyServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

//Netty服务端配置
public class NettyServer {
    public static void main(String[] args) {
        //1.bossGroup只负责处理连接事件，生成 NioSocketChannel,让workerGroup去处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //2.创建服务器启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //3.配置服务启动参数
            serverBootstrap.group(bossGroup, workerGroup)    //指定线程组
                    .channel(NioServerSocketChannel.class) //指定服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道测试对象
                        //给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyServerHandler());//交给这个处理器去处理
                        }
                    });//给workGroup中对应的NioEventLoop设置管道
            System.out.println("netty server is ready.........");
            //4.绑定端口号启动
            ChannelFuture channelFuture = serverBootstrap.bind(8081).sync();
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("success");
                    }else {
                        System.out.println("fail");
                    }
                }
            });
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //优雅的关闭资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
