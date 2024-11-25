package me.yangjun.study.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.yangjun.study.springkafka.TopicConstants;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = TopicConstants.TOPIC_20241125, groupId = "myGroup")
    public void listen(String message) {
        System.out.println("接收到消息：" + message);
    }
}
