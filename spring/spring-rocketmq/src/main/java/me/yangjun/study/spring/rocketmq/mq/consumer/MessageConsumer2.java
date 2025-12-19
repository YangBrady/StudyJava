package me.yangjun.study.spring.rocketmq.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.spring.rocketmq.constants.RocketMQConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(
        topic = RocketMQConstant.PERSON_ARCHIVE_TOPIC,
        consumerGroup = RocketMQConstant.CONSUMER_GROUP2,
        // selectorExpression = RocketMQConstant.CONSUMER_GROUP2_SELECTOR
        selectorExpression = "*"
)
public class MessageConsumer2 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("Consumer2收到信息：{}", message);
    }
}