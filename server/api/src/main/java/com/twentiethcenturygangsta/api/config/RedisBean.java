package com.twentiethcenturygangsta.api.config;

import com.twentiethcenturygangsta.cacheredis.config.RedisConfig;
import com.twentiethcenturygangsta.cacheredis.config.RedissonConfig;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class RedisBean {

    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.port}")
    private int port;

    @Bean
    public RedissonClient redissonClient() {
        return RedissonConfig.createRedissonClient(host, port);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return RedisConfig.createRedisConnectionFactory(host, port);
    }

    @Bean
    public CacheManager cacheManager() {
        return RedisConfig.createCacheManager(redisConnectionFactory());
    }
}
