package com.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisApiSet {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    //1.抽奖小程序
    @Test
    public void actionSet(){
        SetOperations<Object, Object> setOperations = redisTemplate.opsForSet();
        setOperations.add("action_id","user_id_1","user_id_2","user_id_3");
        setOperations.add("action_id","user_id_4","user_id_5","user_id_6");
        setOperations.add("action_id","user_id_7","user_id_8","user_id_9");
        redisTemplate.expire("action_id",2000, TimeUnit.SECONDS);
        Set<Object> action_id = setOperations.members("action_id");
        action_id.forEach(System.out::println);
        System.out.println(setOperations.randomMember("action_id"));
        System.out.println(setOperations.randomMembers("action_id", 2));
        setOperations.pop("action_id",3);
    }
    //2.关注模型，朋友圈展示  略交并差补很简单
}
