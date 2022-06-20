package com.edu.consumer;

import com.edu.framework.ProxyFactory;
import com.edu.provider.api.HelloService;

public class Consumer {
    public static void main(String[] args) {
        //代理对象接口，在执行某个方法的时候做一些其他的事情
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String res = helloService.sayHello("success");
        System.out.println(res);
    }
}
