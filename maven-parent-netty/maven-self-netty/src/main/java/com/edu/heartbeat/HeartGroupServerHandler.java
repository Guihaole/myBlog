package com.edu.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

//心跳服务端的handler
public class HeartGroupServerHandler extends ChannelInboundHandlerAdapter {
    //事件处理方法
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String eventType = null;
            switch (idleStateEvent.state()) {
                case ALL_IDLE:
                    eventType = "read write free";
                    break;
                case READER_IDLE:
                    eventType = "read free";
                    break;
                case WRITER_IDLE:
                    eventType = "write free";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "free eventType" + eventType);
            System.out.println("server ing handler.....");
        }
    }
}
