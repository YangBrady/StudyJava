package me.yangjun.study.springkafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.yangjun.study.springkafka.TopicConstants;
import me.yangjun.study.springkafka.producer.KafkaProducer;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        producer.sendMessage(TopicConstants.TOPIC_20241125, message);
        return "消息发送成功：" + message;
    }
}
