package com.offcn.innerClass;

import com.offcn.thread.Tackite;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestThread {
    @Test
    public void testThreadOne(){
        for (int i = 0; i <30 ; i++) {
            new Tackite().start();
        }
    }
    @Test
    public void testThreadTwo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    System.out.println(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    System.out.println(i);
                }
            }
        }).start();
    }
    @Test
    public void testThreadThree(){
        Callable<Integer> callable = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        };
        new Thread(new FutureTask<Integer>(callable)).start();
        for (int i = 0; i <20 ; i++) {
            System.out.println(i);
        }
    }
}
