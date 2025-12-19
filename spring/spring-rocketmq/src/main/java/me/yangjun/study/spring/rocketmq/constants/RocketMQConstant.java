package me.yangjun.study.spring.rocketmq.constants;

public interface RocketMQConstant {
    String PERSON_ARCHIVE_TOPIC = "PersonArchiveTopic";

    String CONSUMER_GROUP1 = "consumer-group1";
    String CONSUMER_GROUP1_SELECTOR = "all||tag1";

    String CONSUMER_GROUP2 = "consumer-group2";
    String CONSUMER_GROUP2_SELECTOR = "all||tag2";

    String CONSUMER_GROUP_USERPO = "consumerGroup-UserPO";
    String CONSUMER_GROUP_USERPO_SELECTOR = "dev";
}
