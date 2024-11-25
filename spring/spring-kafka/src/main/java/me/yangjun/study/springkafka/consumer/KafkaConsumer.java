package me.yangjun.study.springkafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic", groupId = "myGroup")
    public void listen(String message) {
        System.out.println("接收到消息：" + message);
    }
}
