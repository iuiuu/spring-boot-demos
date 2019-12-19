package com.johnson.web.controllers;

import com.johnson.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author johnson lin
 * @date 2019/12/18 9:11 PM
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    @Qualifier("tagRedisTemplate")
    private RedisTemplate<String, Tag> tagRedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/redis")
    public Object set(String name) {
        // 通过 StringRedisTemplate 保存 name
        stringRedisTemplate.opsForValue().set("strRedisTemplate", name);

        Tag tag = new Tag()
                .setTagId(10001)
                .setTagName(name)
                .setCount(20)
                .setStatus(1);
        // 通过 RedisTemplate<String, Tag> 保存 Tag 实体类
        tagRedisTemplate.opsForValue().set("tagRedisTemplate", tag);


        // 通过 StringRedisTemplate 获取 name
        String strName = stringRedisTemplate.opsForValue().get("strRedisTemplate");

        // 通过 RedisTemplate<String, Tag> 获取 Tag 实体类
        Tag newTag = tagRedisTemplate.opsForValue().get("tagRedisTemplate");

        Map<String, Object> map = new HashMap<>();
        map.put("strName", strName);
        map.put("newTag", newTag);
        return map;

    }

}
