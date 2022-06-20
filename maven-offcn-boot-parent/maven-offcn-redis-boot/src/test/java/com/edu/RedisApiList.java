package com.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisApiList {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    //消息推送
    @Test
    public void messageRedis(){
        BoundListOperations<String, String> user_id = stringRedisTemplate.boundListOps("user_id");
        stringRedisTemplate.expire("user_id",2000, TimeUnit.SECONDS);
        user_id.leftPushAll("message1","message2","message3","message4");
        List<String> list = user_id.range(0, -1);
        list.forEach(System.out::println);
    }
}
