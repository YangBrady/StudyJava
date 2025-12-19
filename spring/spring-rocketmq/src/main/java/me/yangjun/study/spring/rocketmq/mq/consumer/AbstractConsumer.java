package me.yangjun.study.spring.rocketmq.mq.consumer;

import org.apache.rocketmq.spring.core.RocketMQListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractConsumer<T> implements RocketMQListener<T> {
    @Override
    public void onMessage(T message) {}
}