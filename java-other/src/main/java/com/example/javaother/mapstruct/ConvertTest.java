package com.example.javaother.mapstruct;

import com.example.javaother.mapstruct.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.common.po.EnglishUserPO;
import me.yangjun.study.common.po.UserPO;
import org.junit.jupiter.api.Test;

@Slf4j
public class ConvertTest {
    @Test
    public void test01() {
        EnglishUserPO englishUserPO = new EnglishUserPO();
        englishUserPO.setFirstName("zhang");
        englishUserPO.setLastName("san");
        englishUserPO.setAge(18);
        englishUserPO.setSex("male");
        log.info("englishUserPO={}", englishUserPO);

        UserPO user = UserMapper.INSTANCE.formEnglishUser(englishUserPO);
        log.info("user={}", user);
    }
}
