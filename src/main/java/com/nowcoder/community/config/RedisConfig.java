package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @program: community3
 * @description: redis
 * @Author: dongman
 * @create: 2021-06-16 11:37
 **/
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //设置Key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        //value序列化
        template.setValueSerializer(RedisSerializer.json());
        //hash key
        template.setHashKeySerializer(RedisSerializer.string());
        //hash value
        template.setHashValueSerializer(RedisSerializer.json());

        template.afterPropertiesSet();
        return template;
    }
}
