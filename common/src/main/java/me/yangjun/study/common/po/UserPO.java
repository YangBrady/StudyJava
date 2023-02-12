package me.yangjun.study.common.po;

import lombok.Data;

@Data
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
}
