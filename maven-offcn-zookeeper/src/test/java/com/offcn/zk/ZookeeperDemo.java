package com.offcn.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.LockSupport;


public class ZookeeperDemo {
    private static String url="116.205.230.80:2182,116.205.230.80:2183,116.205.230.80:2184";
    private static Integer sessionTimeout=6000;
    private static ZooKeeper zooKeeper;
    @Before
    public void inItZk(){
        try {
            zooKeeper=new ZooKeeper(url, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    try {
                        List<String> children = zooKeeper.getChildren("/", true);
                        System.out.println(children);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void createZkNode(){
        try {
            String s = zooKeeper.create("/guihaole2", "guigege".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(s);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.park();
    }
    @Test
    public void testGetData(){
        try {
            List<String> children = zooKeeper.getChildren("/zookeeper", false);
            System.out.println(children);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSetData(){
        try {
            Stat stat = zooKeeper.setData("/guihaole", "guigedezongzi".getBytes(), 0);
            System.out.println(stat);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //获取子节点中的数据
    @Test
    public void getNodeValue(){
        try {
            Stat stat = new Stat();
            byte[] value = zooKeeper.getData("/guihaole", false, stat);
            System.out.println(new String(value));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void nodeExists(){
        try {
            Stat stat = zooKeeper.exists("/guihaole", false);
            System.out.println(stat);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void delNode(){
        try {
            zooKeeper.delete("/guihaole",1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
