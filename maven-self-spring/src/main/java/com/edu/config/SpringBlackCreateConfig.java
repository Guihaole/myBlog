package com.edu.config;

import com.edu.bean.Cart;
import com.edu.bean.Student;
import com.edu.beanFactory.InitTestBeanPostProcessor;
import com.edu.innerApp.ApplicationContextRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

//spring 的一些黑科技
@Configuration
@PropertySource(value = {"classpath:cart.properties"},encoding = "utf-8")
@Import(ApplicationContextRequired.class)
public class SpringBlackCreateConfig {
//    @Bean
//    public Cart cart(){
//        return new Cart();
//    }
    //测试一下AutoWried
    //3.构造器上----推断构造方法  一个可以省略
    //4.方法上-----从spring创建bean的时候在属性注入的阶段进行调用
    @Bean
    public Student stu(){
        return new Student();
    }
    //1.bean  ----可以省略
    //参数上-----从spring容器中找
    @Bean
    public Cart cart1(@Autowired Student stu){
        Cart cart = new Cart();
        cart.setStudent(stu);
        return cart;
    }
    //2.属性上-----bytype---byname

}
