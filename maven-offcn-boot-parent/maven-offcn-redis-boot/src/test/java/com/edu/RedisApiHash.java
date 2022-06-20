package com.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisApiHash {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    //1.存储对象
    public void addObjectRedis(){
        HashOperations<Object, Object, Object> opsForHash = redisTemplate.opsForHash();
        opsForHash.put("user","name","guigege");
        redisTemplate.expire("user",2000, TimeUnit.SECONDS);
        opsForHash.get("user","name");
        Map<Object, Object> map = opsForHash.entries("user");
    }
    //2.购物车的实现
    @Test
    public void addCartRedis(){
        BoundHashOperations<String, Object, Object> cart_user_id= stringRedisTemplate.boundHashOps("cart_user_id");
        cart_user_id.put("product_id_1","1");
    }
    @Test
    public void deleteCartRedis(){
        BoundHashOperations<String,  Object, Object> cart_user_id= stringRedisTemplate.boundHashOps("cart_user_id");
        cart_user_id.delete("product_id_1");
    }
    @Test
    public void incrCartRedis(){
        BoundHashOperations<String,  Object, Object> cart_user_id= stringRedisTemplate.boundHashOps("cart_user_id");
        cart_user_id.increment("product_id_1",1);
    }
    @Test
    public void decrCartRedis(){
        BoundHashOperations<String,  Object, Object> cart_user_id= stringRedisTemplate.boundHashOps("cart_user_id");
        cart_user_id.increment("product_id_1",-1);
    }
    @Test
    public void getAllCart(){
        BoundHashOperations<String,  Object, Object> cart_user_id= stringRedisTemplate.boundHashOps("cart_user_id");
        Map< Object, Object> entries = cart_user_id.entries();
        Set<Map.Entry< Object, Object>> entries1 = entries.entrySet();
        for (Map.Entry< Object, Object> entry : entries1) {
            System.out.println(entry);
        }
    }
}
