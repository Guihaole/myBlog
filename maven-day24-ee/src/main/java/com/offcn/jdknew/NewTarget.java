package com.offcn.jdknew;

import java.util.function.Consumer;

//新特性
public class NewTarget {
    public void start(){
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer o) {
                System.out.println(o);
            }
        };
        consumer.accept(1);
    }
}
