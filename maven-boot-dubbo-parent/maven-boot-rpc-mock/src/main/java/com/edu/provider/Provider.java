package com.edu.provider;

import com.edu.framework.URL;
import com.edu.framework.protocol.http.HttpServer;
import com.edu.framework.register.LocalRegister;
import com.edu.framework.register.RemoteRegister;
import com.edu.provider.api.HelloService;
import com.edu.provider.impl.HelloServiceImpl;

public class Provider {
    public static void main(String[] args) {
        //接收请求 HTTP请求，Tomcat,Jetty,Undertow
        //接收请求  Tcp请求 netty
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);
        URL url = new URL("localhost", 8080);
        RemoteRegister.register(HelloService.class.getName(),url);
        //启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());
    }
}
