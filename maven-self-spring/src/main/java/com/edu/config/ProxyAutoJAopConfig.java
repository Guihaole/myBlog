package com.edu.config;


import com.edu.aop.AspectClass;
import com.edu.aop.SpringAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
//AnnotationAwareAspectJAutoProxyCreator
public class ProxyAutoJAopConfig {
    //业务类
    @Bean
    public AspectClass aspectClass() {
        return new AspectClass();
    }

    //切面类
    @Bean
    public SpringAop springAop() {
        return new SpringAop();
    }
}
