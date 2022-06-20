package com.offcn.innerClass;
//静态内部类
public class Cat {
    //1.静态内部类可以定义静态的属性
    //2.注意调用的方式
    int Catb=0;
    static class Nacos{
        static int NACOS=123456;
        public static void NacosStart(){
            int start=0;
            System.out.println(start);
            System.out.println(Nacos.NACOS);
            System.out.println(new Cat().Catb);
        }
    }
}
