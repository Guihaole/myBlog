package com.edu.framework.register;

import com.edu.framework.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//注册中心--模拟zookeeper和redis
public class RemoteRegister {
    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        REGISTER = getFile();
        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }

    //解决两个进程数据不能共享----持久化（一台机器可以这么干）---建议使用zookeeper等
    //序列化
    private static void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream("E://tmp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化
    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fis = new FileInputStream("E://tmp.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, List<URL>> object = (Map<String, List<URL>>) ois.readObject();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
