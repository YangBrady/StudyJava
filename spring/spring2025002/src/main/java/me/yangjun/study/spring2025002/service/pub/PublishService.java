package me.yangjun.study.spring2025002.service.pub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PublishService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void publish(String channel, String message) {
        log.info("publish channel: {}, message: {}", channel, message);
        redisTemplate.convertAndSend(channel, message);
    }
}
