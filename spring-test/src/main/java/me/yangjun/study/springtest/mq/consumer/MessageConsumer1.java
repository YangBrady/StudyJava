package me.yangjun.study.springtest.mq.consumer;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springtest.constant.RocketMQConstant;

@Component
@Slf4j
@RocketMQMessageListener(topic = RocketMQConstant.TOPIC, consumerGroup = RocketMQConstant.CONSUMER_GROUP1,
    selectorExpression = RocketMQConstant.CONSUMER_GROUP1_SELECTOR)
public class MessageConsumer1 implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        log.info("Consumer1收到信息：{}，Keys={}，Topic={}", new String(message.getBody()), message.getKeys(),
            message.getTopic());
    }
}