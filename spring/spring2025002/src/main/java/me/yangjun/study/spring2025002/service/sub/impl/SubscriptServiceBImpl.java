package me.yangjun.study.spring2025002.service.sub.impl;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.spring2025002.constants.TopicConstants;
import me.yangjun.study.spring2025002.service.sub.SubscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class SubscriptServiceBImpl implements SubscriptService {
    @Override
    public String getTopic() {
        return TopicConstants.TEST_TOPIC;
    }

    @Override
    public void subscript(String message) {
        log.info("SubscriptServiceBImpl 接收到消息：{}", message);
    }
}
