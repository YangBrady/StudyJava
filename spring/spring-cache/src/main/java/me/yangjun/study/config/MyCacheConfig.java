package me.yangjun.study.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.BatchStrategies;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class MyCacheConfig {
    @Bean
    public RedisCacheManagerBuilderCustomizer RedisCacheManagerBuilderCustomizer(
        RedisConnectionFactory redisConnectionFactory) {
        return builder -> builder.cacheWriter(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory,
            // BatchStrategy 使用 SCAN 游标和多个 DEL 命令来删除所有匹配的键，配置批量大小，以优化扫描批处理。
            BatchStrategies.scan(100)));
    }
}
