package com.edu.config;

import com.edu.bean.Student;
import com.edu.bean.User;
import com.edu.beanFactory.InitTestBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//bean的生命周期的相关配置
//注解发现----推断构造方法------属性注入---初始化前-----初始化-----初始化后-----销毁
public class LifeSpringConfig {

    @Bean
    public InitTestBeanPostProcessor initTestBeanPostProcessor(){
        return new InitTestBeanPostProcessor();
    }
    @Bean
    public Student student(){
        return new Student();
    }
}
