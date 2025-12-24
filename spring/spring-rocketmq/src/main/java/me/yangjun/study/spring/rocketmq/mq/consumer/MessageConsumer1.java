package me.yangjun.study.spring.rocketmq.mq.consumer;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.spring.rocketmq.constants.RocketMQConstant;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RocketMQMessageListener(
        topic = RocketMQConstant.PERSON_ARCHIVE_TOPIC,
        consumerGroup = RocketMQConstant.CONSUMER_GROUP1,
        consumeMode = ConsumeMode.ORDERLY,
        // selectorExpression = RocketMQConstant.CONSUMER_GROUP1_SELECTOR
        selectorExpression = "*"
)
public class MessageConsumer1 implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        log.info("Consumer1收到信息：{}，Keys={}，Topic={}",
                new String(message.getBody()), message.getKeys(), message.getTopic());

        try {
            TimeUnit.SECONDS.sleep(RandomUtil.randomInt(1, 3));
        } catch (InterruptedException e) {
            log.error("sleep error", e);
        }

        // log.info("Consumer1处理信息：{}，Keys={}，Topic={} over",
        //         new String(message.getBody()), message.getKeys(), message.getTopic());
    }
}