package com.edu;

import com.edu.bean.Course;
import com.edu.bean.User;
import com.edu.configruation.AnnoConfiguration;
import com.edu.dao.CourseDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConfigTest {
//    @Test
//    public void testDay01(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("day01/applicationContext.xml");
//        Object beanSelfFactory = context.getBean("beanSelfFactory");
//        System.out.println(beanSelfFactory.toString());
//        User bean =(User) context.getBean("userBean");
//        System.out.println(bean.getClass().getName());
//        User user =(User) context.getBean("insertUser");
//        System.out.println(user.toString());
//    }
//    @Test
//    public void testDay02(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("day02/spring-jdbc.xml");
//        //        User user = (User)context.getBean("user");
//        //        System.out.println(user.toString());
//        //        CourseDao courseDao = context.getBean(CourseDao.class);
//        //        System.out.println(courseDao.selectAll());
//    }
//    @Test
//    public void testDay03(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("day03/spring-druid-dbutils.xml");
//        CourseDao courseDao = context.getBean(CourseDao.class);
//        System.out.println(courseDao);
//        Course course = courseDao.selectCourseById2(5);
//        System.out.println(course);
//    }
    @Test
    public void testAnn(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoConfiguration.class);
        System.out.println(context.getBean(ComboPooledDataSource.class).getUser());
    }
}
