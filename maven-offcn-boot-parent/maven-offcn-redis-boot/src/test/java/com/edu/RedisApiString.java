package com.edu;

import cn.hutool.json.JSONUtil;
import com.edu.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisApiString {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    //1.单值缓存
    @Test
    public void stringRedis(){
//        BoundValueOperations<String, String> name = stringRedisTemplate.boundValueOps("name");
//        name.set("admin",2000, TimeUnit.SECONDS);
//        String s = name.get();
//        System.out.println(s);
        ValueOperations<Object, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("name","admin",100, TimeUnit.SECONDS);
        String name =(String)opsForValue.get("name");
        System.out.println(name);
    }
    //2.对象缓存
    @Test
    public void ObjectRedis(){
        BoundValueOperations<String, String> user = stringRedisTemplate.boundValueOps("user");
        user.set(JSONUtil.toJsonStr(new User("1","guihaole","123456")));
        user.expire(2000,TimeUnit.SECONDS);
        System.out.println(JSONUtil.toBean(user.get(), User.class));
    }
    //3.分布式锁
    @Test
    public void LockRedis(){
        BoundValueOperations<String, String> lock = stringRedisTemplate.boundValueOps("lock");
        String flag=null;
        try {
            UUID uuid = UUID.randomUUID();
            Boolean isBoolean = lock.setIfAbsent(uuid.toString(), 2000, TimeUnit.SECONDS);
            if (isBoolean) {
                //加锁成功
                flag=uuid.toString();
                System.out.println("扣减库存");
            }
        } finally {
            if(flag.equals(lock.get())){
                stringRedisTemplate.delete("lock");
            }
        }
    }
    //点赞功能，验证码校验
    @Test
    public void  incrValue(){
        BoundValueOperations<String, String> boundValueOps = stringRedisTemplate.boundValueOps("user_id");
        boundValueOps.set("1");
        boundValueOps.increment();
        boundValueOps.decrement();
    }

}
