package com.offcn.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aplicationContext.xml");
        context.start();
        System.in.read();
    }
}
