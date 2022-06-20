package com.edu.beanFactory;


import com.edu.bean.Student;
import org.springframework.beans.factory.FactoryBean;

//注意知识点factorybean 和beanfactory的区别
public class StudentFactory implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
