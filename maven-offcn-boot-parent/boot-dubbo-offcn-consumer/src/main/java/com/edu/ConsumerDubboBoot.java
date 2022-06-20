package com.edu;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDubbo
@SpringBootApplication
@EnableSwagger2
public class ConsumerDubboBoot {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerDubboBoot.class,args);
    }
}
