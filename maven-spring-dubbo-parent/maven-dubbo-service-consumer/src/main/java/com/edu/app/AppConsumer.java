package com.edu.app;

import com.edu.service.SiteService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-consumer-dubbo.xml");
        context.start();
        SiteService siteService =(SiteService) context.getBean("siteService");
        String name = siteService.getName("hello");
        System.out.println(name);
    }
}
