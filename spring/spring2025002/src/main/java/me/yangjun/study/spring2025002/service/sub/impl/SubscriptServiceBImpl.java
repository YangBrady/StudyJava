package me.yangjun.study.spring2025002.service.sub.impl;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.spring2025002.service.sub.SubscriptService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubscriptServiceBImpl implements SubscriptService {
    @Override
    public void subscript(String message) {
        log.info("SubscriptServiceBImpl 接收到消息：{}", message);
    }
}
