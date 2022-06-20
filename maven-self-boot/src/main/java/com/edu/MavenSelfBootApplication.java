package com.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.edu.mapper")
public class MavenSelfBootApplication {

    /**
     *springbootApplication  ---compmentScan 自动配置的过滤器filter
     * -------------------------springbootconfigrion
     * ---------------------------EnableAutoConfigration----enableconfigpakges用于扫描启动类下的包
     * -------importselector----实现变种的  返回一个group自动配置类，process方法,获取所有的自动配置getautoconfigtion---list,128---通过过滤
     * ----------在注入到容器中，怎么获取的跟到list集合怎么获取的，通过spring.factors文件 key  value的形式
     */
    public static void main(String[] args) {
        SpringApplication.run(MavenSelfBootApplication.class, args);
    }

}
