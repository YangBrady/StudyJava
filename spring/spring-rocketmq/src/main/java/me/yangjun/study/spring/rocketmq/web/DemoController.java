package me.yangjun.study.spring.rocketmq.web;

import me.yangjun.study.common.po.UserPO;
import me.yangjun.study.spring.rocketmq.mq.producer.UserPOProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private UserPOProducer userPOProducer;

    @GetMapping("/testSendMsg/{tag}")
    public SendResult testSendMsg(@PathVariable("tag") String tag) {
        UserPO userPO = UserPO.builder().age(30).name("哇哈哈").build();

        SendResult sendResult;
        if ("basic".equalsIgnoreCase(tag)) {
            sendResult = userPOProducer.sendBasicMessage(userPO);
        } else {
            sendResult = userPOProducer.sendCardMessage(userPO);
        }
        return sendResult;
    }
}
