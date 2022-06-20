package com.edu.config;

import com.edu.bean.Cart;
import com.edu.bean.User;
import com.edu.beanFactory.BeanSelectImport;
import com.edu.beanFactory.BeanSelectImportRegister;
import com.edu.beanFactory.StudentFactory;
import com.edu.mapper.impl.UserMapperImpl;
import org.springframework.context.annotation.*;

//配置类  组件注入
@Configuration
//1.ComponetScan注解注入


@ComponentScan(
basePackages = {"com.edu"}
,excludeFilters ={@ComponentScan.Filter(classes = {UserMapperImpl.class},type = FilterType.ASSIGNABLE_TYPE)}
)
//4.Import
@Import({Cart.class,BeanSelectImport.class, BeanSelectImportRegister.class})
//5.ImportSelector
//6.ImportBeanDefinitionRegistrar
public class ApplicationConfig {
    //2.factoryBean组件注入
    @Bean
    public StudentFactory studentFactory(){
        return new StudentFactory();
    }
    //3. bean组件注入注意用法
    @Bean
    public User myUser(){
        return new User("001","hehe","6666");
    }
    //7.Conditional
}
