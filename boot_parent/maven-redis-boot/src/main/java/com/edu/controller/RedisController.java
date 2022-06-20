package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    //http://localhost:8080/redis/test
    @GetMapping("/test")
    public String redisTest() {
        redisTemplate.opsForValue().set("123", "111");
        String key = (String) redisTemplate.opsForValue().get("123");
        return key;
    }
}
