package com.offcn.innerClass;
//成员
public class A {
    //1.成员内部类不可定义静态属性
    public int AA=01;
    class B{
        public int BB=02;
        public void B1(){
            int BB1=00;
            System.out.println(BB1);
            System.out.println(this.BB);
            System.out.println(A.this.AA);
        }
    }
}
