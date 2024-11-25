package me.yangjun.study.springkafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.yangjun.study.springkafka.producer.KafkaProducer;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        producer.sendMessage("testTopic", message);
        return "消息发送成功：" + message;
    }
}
