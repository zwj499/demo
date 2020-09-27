package com.springboot.demo.controller;

import com.springboot.demo.entity.sys.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/set")
    public String set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    @GetMapping("/get")
    public String set(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }


}
