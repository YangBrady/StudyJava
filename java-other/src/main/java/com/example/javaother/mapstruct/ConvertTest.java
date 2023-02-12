package com.example.javaother.mapstruct;

import com.example.javaother.mapstruct.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.common.po.EnglishUserPO;
import me.yangjun.study.common.po.UserPO;
import org.junit.jupiter.api.Test;

@Slf4j
public class ConvertTest {
    @Test
    public void testFormEnglishUser1() {
        EnglishUserPO user1 = EnglishUserPO.builder()
                .firstName("zhang")
                .lastName("san")
                .age(18)
                .sex("male")
                .build();
        log.info("user1={}", user1);

        UserPO user = UserMapper.INSTANCE.formEnglishUser1(user1);
        log.info("user={}", user);

        EnglishUserPO user2 = new EnglishUserPO();
        user2.setSex("female");
        user = UserMapper.INSTANCE.formEnglishUser2(user1, user2);
        log.info("user={}", user);
    }

    @Test
    public void testFormEnglishUser2() {
        EnglishUserPO user1 = EnglishUserPO.builder()
                .firstName("zhang")
                .lastName("san")
                .age(18)
                .sex("male")
                .phoneNum("12345678901")
                .build();
        log.info("user1={}", user1);

        EnglishUserPO user2 = EnglishUserPO.builder()
                .firstName("li")
                .lastName("si")
                .age(19)
                .sex("female")
                .phoneNum("12345678902")
                .build();
        log.info("user2={}", user2);

        UserPO user = UserMapper.INSTANCE.formEnglishUser2(user1, user2);
        log.info("user={}", user);
    }
}
