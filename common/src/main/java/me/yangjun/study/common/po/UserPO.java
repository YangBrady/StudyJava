package me.yangjun.study.common.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号
     */
    private String phoneNum;

    public static List<UserPO> genUserPOList(int size) {
        List<UserPO> userPOList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            UserPO userPO = UserPO.builder()
                    .name(RandomStringUtils.randomAlphabetic(5))
                    .age(Integer.parseInt(RandomStringUtils.randomNumeric(2, 3)))
                    .sex(RandomStringUtils.random(1, "MF"))
                    .phoneNum(RandomStringUtils.randomAlphabetic(11))
                    .build();
            userPOList.add(userPO);
        }
        return userPOList;
    }
}
