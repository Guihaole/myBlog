package com.edu.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URL;

public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        //判断msg是不是一个http请求
        if (httpObject instanceof HttpRequest) {
            System.out.println("ctx pipeline hashcode: " + ctx.pipeline().hashCode()
                    + "HttpServerHandler hashcode: " + this.hashCode());
            System.out.println("msg type = " + httpObject.getClass());
            System.out.println("client address: " + ctx.channel().remoteAddress());
            //获取到
            HttpRequest httpRequest = (HttpRequest) httpObject;
//            URL url = new URL(httpRequest.uri());
//            if ("favicon.ico".equals(url.getPath())) {
//                System.out.println("favicon.ico File request , not response");
//                return;
//           }
            //回复信息给浏览器http协议
            ByteBuf content = Unpooled.copiedBuffer("hello ,my name is httpServer", CharsetUtil.UTF_8);
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
        }
    }
}
