package com.offcn.map;
import sun.misc.Unsafe;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SearchMap {
    //map集合
    public void start(){
        //1. hashmap的key值可以为null,treemap不可以
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null,"username");
        hashMap.put("123456","password");
        //2. map是以key,value存值，map中的key是不允许重复的
        //3. hashmap线程不安全，hashtable线程安全，可以使用currenthashmap解决线程安全问题
        //4. 1.7是数组+链表（简单）;1.8是数组+链表+红黑树(简单);
        hashMap.put("123","ujiuye");
        //5. currenthashmap线程安全：1.7是基于分段的seqment进行实现，1.8cas技术
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("key","value");
        concurrentHashMap.put("key2","value2");
        //6. hashmap的遍历方式
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getValue() + "---" + entry.getKey());
        }
        Set<String> keySet = hashMap.keySet();
        for (String s : keySet) {
            System.out.println(s+"----"+hashMap.get(s));
        }
        //Unsafe unsafe = Unsafe.getUnsafe();
        //unsafe.compareAndSwapInt()
    }

}
