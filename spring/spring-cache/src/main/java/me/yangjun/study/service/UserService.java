package me.yangjun.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Cacheable(cacheNames = "spring-cache-userCache")
    public String get(String userId) {
        log.info("get user, userid= {}", userId);
        return "用户" + userId;
    }

    @CachePut(cacheNames = "spring-cache-userCache", key = "#userId")
    public String set(String userId, String newName) {
        return "用户"  + userId + newName;
    }

    @CacheEvict(cacheNames = "spring-cache-userCache", key = "#userId")
    public void delete(String userId) {
    }

    @CacheEvict(cacheNames = "spring-cache-userCache", allEntries = true)
    public void deleteAll() {
    }
}
