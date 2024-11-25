package me.yangjun.study.springtest.mq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springtest.constant.RocketMQConstant;

@Component
@Slf4j
@RocketMQMessageListener(topic = RocketMQConstant.TOPIC, consumerGroup = RocketMQConstant.CONSUMER_GROUP2,
    selectorExpression = RocketMQConstant.CONSUMER_GROUP2_SELECTOR)
public class MessageConsumer2 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("Consumer2收到信息：{}", message);
    }
}