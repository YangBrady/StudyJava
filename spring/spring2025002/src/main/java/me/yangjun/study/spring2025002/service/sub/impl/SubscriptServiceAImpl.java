package me.yangjun.study.spring2025002.service.sub.impl;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.spring2025002.constants.TopicConstants;
import me.yangjun.study.spring2025002.service.sub.SubscriptService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubscriptServiceAImpl implements SubscriptService {
    @Override
    public String getTopic() {
        return TopicConstants.TEST_TOPIC;
    }

    @Override
    public void handleMessage(String message) {
        log.info("SubscriptServiceAImpl 接收到消息：{}", message);
    }
}
