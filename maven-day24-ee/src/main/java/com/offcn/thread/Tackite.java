package com.offcn.thread;

public class Tackite extends Thread{
    private int tackCount=30;
    @Override
    public void run() {
        while (true){
           if (tackCount<=0){
               break;
           }
           tackCount--;
        }
    }
}
