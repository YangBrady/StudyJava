package me.yangjun.study.spring.rocketmq.mq.producer;

import me.yangjun.study.common.po.UserPO;
import me.yangjun.study.spring.rocketmq.constants.RocketMQConstant;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.stereotype.Component;

@Component
public class UserPOProducer extends AbstractProducer<UserPO> {
    public SendResult sendBasicMessage(UserPO userPO) {
        return sendMessage(RocketMQConstant.PERSON_ARCHIVE_TOPIC, "basic", userPO);
    }

    public SendResult batchSendBasicMessage(UserPO userPO) {
        SendResult result = null;
        for (int i = 0; i < 10; i++) {
            userPO.setAge(i);
            result = sendMessageOrderly(RocketMQConstant.PERSON_ARCHIVE_TOPIC, "basic", userPO);
        }
        return result;
    }

    public SendResult sendCardMessage(UserPO userPO) {
        return sendMessage(RocketMQConstant.PERSON_ARCHIVE_TOPIC, "card", userPO);
    }
}
