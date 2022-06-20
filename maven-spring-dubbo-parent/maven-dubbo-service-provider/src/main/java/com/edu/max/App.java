package com.edu.max;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider-spring-config.xml");
        context.start();
        try {
            System.in.read();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
