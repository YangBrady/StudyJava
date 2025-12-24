package me.yangjun.study.spring.rocketmq.mq.consumer;

import me.yangjun.study.spring.rocketmq.constants.RocketMQConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.common.po.UserPO;

// @Component
@Slf4j
@RocketMQMessageListener(
        topic = RocketMQConstant.PERSON_ARCHIVE_TOPIC,
        consumerGroup = RocketMQConstant.CONSUMER_GROUP_USERPO,
        // selectorExpression = RocketMQConstant.CONSUMER_GROUP_USERPO_SELECTOR
        selectorExpression = "*"
)
public class UserPOConsumer implements RocketMQListener<UserPO> {

    // @Autowired
    // private UserMapper userMapper;

    @Override
    public void onMessage(UserPO userPO) {
        log.info("Consumer3收到信息：{}", JSON.toJSONString(userPO));
        // UserVO userVO = new UserVO();
        // userVO.setName(userPO.getName());
        // userVO.setAge(userPO.getAge());
        // userMapper.insert(userVO);
    }
}