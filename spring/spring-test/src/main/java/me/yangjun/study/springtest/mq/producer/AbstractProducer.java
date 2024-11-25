package me.yangjun.study.springtest.mq.producer;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springtest.constant.RocketMQConstant;

@Slf4j
public abstract class AbstractProducer<T> {
    @Autowired
    private RocketMQTemplate rocketmqTemplate;

    private final String tag;

    public AbstractProducer(String tag) {
        this.tag = tag;
    }

    public SendResult onMessage(T messagePO) {
        String destination = RocketMQConstant.TOPIC + ":" + this.tag;
        Message<T> message = MessageBuilder.withPayload(messagePO).setHeader(RocketMQHeaders.KEYS, "key").build();
        return rocketmqTemplate.syncSend(destination, message);
    }
}