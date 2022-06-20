package com.offcn.Class;

public interface JavaSEClass {
    //1.静态常量
    public static final Integer MAX_VALUE=100;
    int a=0;//默认加了static final
    //2.公共的抽象方法
    public  void  start();
    //3.接口可以被接口多继承，可以被继承
    //4.接口可以被子类实现，必须实现所有的方法
}
