package com.johnson.config;

import com.johnson.model.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author johnson lin
 * @date 2019/12/18 9:14 PM
 */
@Configuration
public class RedisConfig {
    @Bean("tagRedisTemplate")
    public RedisTemplate<String, Tag> tagRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Tag> template = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<Tag> serializer = new Jackson2JsonRedisSerializer<>(Tag.class);
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
