package com.offcn.innerClass;

import com.offcn.Class.Abstraction;

//局部
public class Inner {
    //1.注意this代表的是当前对象
    //2.局部内部类的使用方法
    private int InnerVar=1001;
    public void start(){
        String startVar="name";
        class StartClass{
            private String startClassVar="password";
        }
        System.out.println(this.InnerVar);
        System.out.println(startVar);
        System.out.println(new StartClass().startClassVar);
        Abstraction abstraction=new Abstraction(){
            @Override
            public void start() {
                System.out.println("start");
            }

            @Override
            public void end() {
                System.out.println("hehe");
            }
        };
        abstraction.start();
        abstraction.end();
    }
    public void zhuanhuan(){
        //拆箱
        Long long2=10002l;
        long2.longValue();
        //装箱
        //1.new 构造器（）
        //2.valueOf()
        Integer integer = Integer.valueOf(2);
    }
}
