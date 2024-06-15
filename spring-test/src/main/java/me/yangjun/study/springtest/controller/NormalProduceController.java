package me.yangjun.study.springtest.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.yangjun.study.common.po.UserPO;
import me.yangjun.study.springtest.mq.producer.UserPOProducer;

@RestController
public class NormalProduceController {
    @Autowired
    private UserPOProducer userPOProducer;

    @GetMapping("/testSendMsg")
    public SendResult testSendMsg() {
        UserPO userPO = UserPO.builder().age(30).name("哇哈哈").build();
        return userPOProducer.onMessage(userPO);
    }
}
