package me.yangjun.study.springtest.mq.producer;

import org.springframework.stereotype.Component;

import me.yangjun.study.common.po.UserPO;

@Component
public class UserPOProducer extends AbstractProducer<UserPO> {
    public static final String TAG = "userPOTag";

    public UserPOProducer() {
        super(TAG);
    }
}
