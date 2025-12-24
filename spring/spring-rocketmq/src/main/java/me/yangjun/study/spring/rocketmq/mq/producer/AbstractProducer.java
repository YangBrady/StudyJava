package me.yangjun.study.spring.rocketmq.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
public abstract class AbstractProducer<T> {
    @Autowired
    private RocketMQTemplate rocketmqTemplate;

    public SendResult sendMessage(String topic, String tag, T messagePO) {
        String destination = topic + ":" + tag;
        Message<T> message = MessageBuilder
                .withPayload(messagePO)
                .setHeader(RocketMQHeaders.KEYS, "key")
                .build();
        return rocketmqTemplate.syncSend(destination, message);
    }

    public SendResult sendMessageOrderly(String topic, String tag, T messagePO) {
        String destination = topic + ":" + tag;
        Message<T> message = MessageBuilder
                .withPayload(messagePO)
                .setHeader(RocketMQHeaders.KEYS, "key")
                .build();
        return rocketmqTemplate.syncSendOrderly(destination, message, "test_sync_send_order");
    }

    public void send(String topic, String tag, T messagePO) {
        String destination = topic + ":" + tag;
        Message<T> message = MessageBuilder
                .withPayload(messagePO)
                .setHeader(RocketMQHeaders.KEYS, "key")
                .build();
        rocketmqTemplate.send(destination, message);
    }
}