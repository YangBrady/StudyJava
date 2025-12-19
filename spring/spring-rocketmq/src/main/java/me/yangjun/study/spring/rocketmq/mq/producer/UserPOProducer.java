package me.yangjun.study.spring.rocketmq.mq.producer;

import me.yangjun.study.common.po.UserPO;
import me.yangjun.study.spring.rocketmq.constants.RocketMQConstant;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.stereotype.Component;

@Component
public class UserPOProducer extends AbstractProducer<UserPO> {
    public SendResult sendBasicMessage(UserPO userPO) {
        return onMessage(RocketMQConstant.PERSON_ARCHIVE_TOPIC, "basic", userPO);
    }

    public SendResult sendCardMessage(UserPO userPO) {
        return onMessage(RocketMQConstant.PERSON_ARCHIVE_TOPIC, "card", userPO);
    }
}
