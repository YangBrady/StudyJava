package me.yangjun.study.spring2025004.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("test")
@Slf4j
public class DemoWeb {
    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("sayHi/{word}")
    public String sayHi(@PathVariable("word") String word) {
        String lockKey = "spring2025004_" + word;
        RLock lock = redissonClient.getLock(lockKey);
        String result = "";
        try {
            log.info("lockKey:{}", lockKey);
            boolean lockResult = lock.tryLock(3, 120, TimeUnit.SECONDS);
            boolean lockResult2 = lock.tryLock(3, TimeUnit.SECONDS);
            if (lockResult) {
                TimeUnit.SECONDS.sleep(60);
                result = word;
            }
        } catch (InterruptedException e) {
            log.error("demo error", e);
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return result;
    }
}
