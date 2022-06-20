package com.edu.framework;

import java.util.List;
import java.util.Random;
//负载均衡算法---可以自己设计多种
public class LoadBalance {
    public static URL random(List<URL> list) {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
