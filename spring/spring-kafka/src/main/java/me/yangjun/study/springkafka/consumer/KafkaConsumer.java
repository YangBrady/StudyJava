package me.yangjun.study.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springkafka.constant.GroupConstants;
import me.yangjun.study.springkafka.constant.TopicConstants;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = TopicConstants.TOPIC_20241125, groupId = GroupConstants.GROUP_A)
    public void listen(String message) {
        log.info("接收到消息：{}", message);
    }
}
