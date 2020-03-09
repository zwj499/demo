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

    private final StringRedisTemplate stringRedisTemplate;

    public TestController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/set")
    public String set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    @GetMapping("get")
    public String set(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @GetMapping("/mongo")
    public TT setMongo() {
        TT tt = new TT("as", "good");
        return mongoTemplate.save(tt, "sys_user");
    }

    @GetMapping("/mongoget")
    public List<TT> sgtMongo() {
        return mongoTemplate.findAll(TT.class, "sys_user");
    }

}

class TT {
    private String name;
    private String description;

    public TT(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}