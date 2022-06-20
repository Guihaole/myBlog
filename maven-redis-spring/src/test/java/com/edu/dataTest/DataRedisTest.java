package com.edu.dataTest;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicatonContext.xml")
public class DataRedisTest {
    @Autowired
    private JedisPool jedisPool;
    //字符串结构
    @Test
    public void JedisString(){
        //分布式锁，存对象，存值，计数器
        Jedis jedis = jedisPool.getResource();
        jedis.msetnx("k1","v1","k2","v2","k3","v3","k4","v4");
        jedis.expire("k1",1000);
        jedis.setex("name",2000,"guihaole");
        System.out.println(jedis.get("k1"));
    }
    //hash结构
    @Test
    public void JedisHash(){
        //购物车模型
        Jedis jedis = jedisPool.getResource();
        jedis.hset("cart_user_Id","product_Id0","10");
        HashMap<String, String> map = new HashMap<>();
        map.put("product_Id1","10");
        map.put("product_Id2","10");
        map.put("product_Id3","10");
        jedis.hmset("cart_user_Id",map);
        //所有
        Map<String, String> mapCart = jedis.hgetAll("cart_user_Id");
        System.out.println(JSON.toJSONString(mapCart));
        //数量加1
        jedis.hincrBy("cart_user_Id","product_Id1",12);
        jedis.hdel("cart_user_Id","product_Id2");
        //所有
        Map<String, String> mapCart2 = jedis.hgetAll("cart_user_Id");
        System.out.println(JSON.toJSONString(mapCart2));
    }
    //list结构
    @Test
    public void JedisList(){
        //抖音消息推送
        Jedis jedis = jedisPool.getResource();
        jedis.lpush("my_Id","message1","message2","message3","message4");
        List<String> my_id_List = jedis.lrange("my_Id", 0, -1);
        System.out.println(JSON.toJSONString(my_id_List));
    }
    //set结构
    @Test
    public void JedisSet(){
        //1. 抽奖小程序
        Jedis jedis = jedisPool.getResource();
        jedis.sadd("action_weiXi_Id","userId1","userId2","userId3",
                "userId4","userId5","userId6","userId7","userId8");
        Set<String> action_weiXi_id_List = jedis.smembers("action_weiXi_Id");
        action_weiXi_id_List.forEach(s -> {
            System.out.print(s);
        });
        //一级抽奖
        Set<String> setFirst = jedis.spop("action_weiXi_Id", 1);
        setFirst.forEach(System.out::println);
        //二级抽奖
        Set<String> setSecond = jedis.spop("action_weiXi_Id",2);
        setSecond.forEach(System.out::println);
        //三等奖
        Set<String> setThree = jedis.spop("action_weiXi_Id",3);
        setThree.forEach(System.out::println);
    }
    @Test
    public void JedisSetDemo2(){
        //2. 模拟关注模型
        Jedis jedis = jedisPool.getResource();
        jedis.sadd("maChaoId","heima","offcn","heima","guigu");
        jedis.sadd("guiHaoLeId","qifeng","offcn","guigu","tuling");
        //我可能认识的人
        jedis.sdiff("guiHaoLeId","maChaoId").forEach(System.out::println);
        //我两共同关注的机构
        jedis.sunion("guiHaoLeId","maChaoId").forEach(System.out::println);
    }
    //zset结构
    @Test
    public void JedisZset(){
        //3.模拟热点新闻排行榜
        Jedis jedis = jedisPool.getResource();
        HashMap<String, Double> map = new HashMap<>();
        map.put("IT就业平均薪资暴露",3.6);
        map.put("IT就业平均薪资暴露1",5.6);
        map.put("IT就业平均薪资暴露2",7.6);
        map.put("IT就业平均薪资暴露3",9.6);
        jedis.zadd("day_new_score_Id",map);
        Set<String> set = jedis.zrange("day_new_score_Id", 0, -1);
        set.forEach(System.out::println);
        jedis.flushDB();
    }
}
