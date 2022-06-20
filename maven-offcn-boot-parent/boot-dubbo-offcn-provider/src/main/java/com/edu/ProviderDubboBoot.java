package com.edu;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = "com.edu.mapper")
public class ProviderDubboBoot {
    public static void main(String[] args) {
        SpringApplication.run(ProviderDubboBoot.class,args);
    }
}
