package com.offcn.thread;

import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {
    public void test(){
        //1.无论是那个线程池，我们都需要创建threadPoolExecutor
        //2.核心线程数，最大线程数，活跃时间，拒绝异常，队列
        //3.单个和固定为何会oom  cached为何会cpu100%
        Executors.newCachedThreadPool();
    }
}
