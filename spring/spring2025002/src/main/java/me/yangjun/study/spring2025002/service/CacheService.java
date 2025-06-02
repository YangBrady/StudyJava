package me.yangjun.study.spring2025002.service;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.Cache;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.spring2025002.constants.TopicConstants;
import me.yangjun.study.spring2025002.service.pub.PublishService;

@Service
@Slf4j
public class CacheService {

    private static final String REDIS_CACHE_PREFIX = "redis_cache:";

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private Cache<String, String> caffeineCache;

    @Autowired
    private PublishService publishService;

    // TODO 要考虑并发
    // 获取缓存值
    public String get(String key) {
        log.debug("先查本地缓存");
        String value = caffeineCache.getIfPresent(key);
        if (value != null) {
            return value;
        }

        log.debug("本地缓存没有，查Redis");
        String redisValue = redisTemplate.opsForValue().get(REDIS_CACHE_PREFIX + key);
        if (redisValue != null) {
            log.debug("重新填充本地缓存");
            caffeineCache.put(key, redisValue);
            return redisValue;
        }

        return null;
    }

    // TODO 要考虑并发
    // 设置缓存
    public void set(String key, String value, long timeout, TimeUnit unit) {
        log.debug("设置Redis缓存");
        redisTemplate.opsForValue().set(REDIS_CACHE_PREFIX + key, value, timeout, unit);
        log.debug("设置本地缓存");
        caffeineCache.put(key, value);
    }

    // TODO 要考虑并发
    // 清理缓存
    public void evict(String key) {
        log.debug("删除Redis缓存");
        redisTemplate.delete(REDIS_CACHE_PREFIX + key);

        publishService.publish(TopicConstants.TEST_TOPIC, key);
    }
}