package com.edu.beanFactory;

import com.edu.bean.Student;
import com.edu.bean.User;

public class BeanSelfFactory {

    //静态工厂生产对象
    public static Student studentBean(){
        return new Student();
    }
    //实例工厂生产对象
    public User userBean(){
        return new User();
    }
}
