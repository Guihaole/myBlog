package com.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@MapperScan("com.edu.mapper")
//将mybatis的接口生成代理对象放入ioc中
public class MybatisPlusBootMain {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusBootMain.class,args);
    }
}
