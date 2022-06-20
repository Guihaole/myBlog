package com.offcn.end;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射
public class Reflection {
    //反射创建的三种方式
    public void createReflect() throws ClassNotFoundException {
        Class<? extends Object> aClass = Class.forName("com.offcn.end.Photo");//代表反射的class对象必须是子类
        Class<? extends Reflection> aClass1 = this.getClass();
        Class<? super Photo> aClass2 = Object.class;//代表的是Photo的父类才满足条件
    }
    //反射的应用
    public void useReflect() throws Exception {
        Class<?> aClass = Class.forName("com.offcn.end.Photo");
        //获取构造器
        Constructor<?> constructor = aClass.getConstructor();
        Photo photo = (Photo)constructor.newInstance();
        //执行方法
        Method method = aClass.getDeclaredMethod("startPrivate");
        method.setAccessible(true);
        method.invoke(photo);
        //属性赋值
        Field width = aClass.getDeclaredField("width");
        width.setAccessible(true);
        Field height = aClass.getDeclaredField("height");
        height.setAccessible(true);
        width.set(photo,100);
        height.set(photo,100);

        Method area = aClass.getDeclaredMethod("setArea", Integer.class, Integer.class);
        area.invoke(photo,10,10);
        System.out.println(photo.getWidth()+"-------"+photo.getHeight()+"----"+photo.getArea());
    }
    //获取接口和注解
    public void getInterface() throws Exception{
        Class<?> aClass = Class.forName("com.offcn.end.Photo");
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Method toString = aClass.getDeclaredMethod("toString");
        Override annotation = toString.getAnnotation(Override.class);
    }
}
