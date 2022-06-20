package com.edu.netty.nettyServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.Timeout;

import java.util.concurrent.TimeUnit;

//NettyServer处理业务的逻辑，相当于servlet的作用
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 读取客户端请求数据
     *
     * @param ctx 可以获取到channel的信息和pipeline的信息
     * @param msg 客户端发送的数据  可以转成一个ByteBuf
     * @throws Exception
     */
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("Server thread" + Thread.currentThread().getName());
//        System.out.println("Server ctx: " + ctx);
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("Client send message: " + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("Client location: " + ctx.channel().remoteAddress());
//    }
    //超时业务，提交到队列进行异步处理
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //自定义提交到普通队列 taskQueue
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello client2 ", CharsetUtil.UTF_8));
                    System.out.println("code channel: "+ctx.channel().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello client3 ", CharsetUtil.UTF_8));
                    System.out.println("code channel: "+ctx.channel().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //自定义提交到定时队列 scheduledTask
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello client4 ", CharsetUtil.UTF_8));
                    System.out.println("code channel: "+ctx.channel().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },5,TimeUnit.SECONDS);
        System.out.println("-------------");
    }

    /**
     * 读取完毕，响应客户端数据
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello client ", CharsetUtil.UTF_8));
    }

    /**
     * 发生异常关闭通道
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
