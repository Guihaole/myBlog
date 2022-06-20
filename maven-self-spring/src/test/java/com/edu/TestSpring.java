package com.edu;

import com.edu.aop.AspectClass;
import com.edu.bean.A;
import com.edu.bean.Cart;
import com.edu.bean.Register;
import com.edu.bean.Student;
import com.edu.config.*;
import com.edu.innerApp.ApplicationContextRequired;
import com.edu.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    @Test
    public void  test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
                        for (String name : context.getBeanDefinitionNames()) {
                            System.out.println(name);
                        }
        //        import获取bean的方式
        //        A a = (A)context.getBean("com.edu.bean.A");
        //        System.out.println(a);
        //        System.out.println("================");
        //        Object studentFactory = context.getBean("studentFactory");
        //        if (studentFactory instanceof Student) {
        //            System.out.println("它是一个student对象");
        //        }
        //        Object bean = context.getBean("&studentFactory");
        //        Object bean1 = context.getBean("myUser");
        //        System.out.println(bean1);

    }
    @Test
    public void  test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppComponentScanConfig.class);
        AppComponentScanConfig bean = (AppComponentScanConfig) context.getBean("appComponentScanConfig");
        System.out.println(bean);
        //        context.destroy();
    }
    @Test
    public void  test3(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProxyAutoJAopConfig.class);
        //        Cart cart = (Cart)context.getBean("cart1");
        //        System.out.println(cart.getStudent());
        //        Student stu = (Student)context.getBean("stu");
        //        System.out.println(stu);
        //        UserService userServiceImpl = (UserService)context.getBean("userServiceImpl");
        //        userServiceImpl.systemPrint();
        //        ApplicationContextRequired bean =
        //                (ApplicationContextRequired)context.getBean("com.edu.innerApp.ApplicationContextRequired");
        AspectClass contextBean = (AspectClass)context.getBean("aspectClass");
        contextBean.selectAop();
    }
}
