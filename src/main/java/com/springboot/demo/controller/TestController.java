package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final StringRedisTemplate stringRedisTemplate;

    public TestController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @PostMapping("/set")
    public String set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    @GetMapping("get")
    public String set(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
