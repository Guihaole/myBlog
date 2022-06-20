package com.offcn.genericity;

public class Genericity <T>{
    //1.泛型只能是引用类型
    //2.泛型作用在类上，不能使用泛型new对象
    //3.泛型作用在属性上，不能使用泛型常量
    //4.泛型作用在方法上，可以是返回值，也可以是参数类型；
    //5.泛型作用在接口上，可以直接被实现传参，也可以被连续继承
    private T obj;

    public T getObj() {
        return obj;
    }
    public void start(T target){
        System.out.println(target);
    }
}
