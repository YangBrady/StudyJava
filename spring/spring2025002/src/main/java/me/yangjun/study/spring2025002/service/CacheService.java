package me.yangjun.study.spring2025002.service;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.Cache;

@Service
@Slf4j
public class CacheService {

    private static final String REDIS_CACHE_PREFIX = "redis_cache:";
    private static final String CACHE_CLEAR_CHANNEL = "cache_clear_channel";

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private Cache<String, String> caffeineCache;

    // 获取缓存值
    public String get(String key) {
        log.debug("先查本地缓存");
        String value = caffeineCache.getIfPresent(key);
        if (value == null) {
            log.debug("本地缓存没有，查Redis");
            value = redisTemplate.opsForValue().get(REDIS_CACHE_PREFIX + key);
            if (value != null) {
                log.debug("重新填充本地缓存");
                caffeineCache.put(key, value);
            }
        }
        return value;
    }

    // 设置缓存
    public void set(String key, String value, long timeout, TimeUnit unit) {
        log.debug("设置Redis缓存");
        redisTemplate.opsForValue().set(REDIS_CACHE_PREFIX + key, value, timeout, unit);
        log.debug("设置本地缓存");
        caffeineCache.put(key, value);
    }

    // 清理缓存
    public void evict(String key) {
        log.debug("删除本地缓存");
        caffeineCache.invalidate(key);
        log.debug("删除Redis缓存");
        redisTemplate.delete(REDIS_CACHE_PREFIX + key);
        // 发布缓存清理消息到Redis频道
        redisTemplate.convertAndSend(CACHE_CLEAR_CHANNEL, key);
    }

    // 订阅缓存清理消息
    public void subscribeCacheClearMessage(String key) {
        redisTemplate.getConnectionFactory().getConnection().subscribe((message, pattern) -> {
            String receivedKey = new String(message.getBody());
            String channel = new String(message.getChannel());

            if (CACHE_CLEAR_CHANNEL.equals(channel) && key.equals(receivedKey)) {
                // 收到其他实例的缓存清理通知后，清理本地缓存
                caffeineCache.invalidate(key);
            }
        }, CACHE_CLEAR_CHANNEL.getBytes());
    }
}