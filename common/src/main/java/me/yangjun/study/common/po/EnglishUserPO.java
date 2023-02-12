package me.yangjun.study.common.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnglishUserPO {
    /**
     * 第一个名字
     */
    private String firstName;
    /**
     * 姓
     */
    private String lastName;
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
}
