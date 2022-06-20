package com.edu;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class InitBootMain {
    public static void main(String[] args) {
        SpringApplication.run(InitBootMain.class,args);
        //springboot stars:>5000
    }
}
