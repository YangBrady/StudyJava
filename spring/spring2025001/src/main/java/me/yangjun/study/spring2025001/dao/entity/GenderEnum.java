package me.yangjun.study.spring2025001.dao.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderEnum {
    F("女性", "F"),
    M("男性", "M");

    private final String genderZhName;

    @EnumValue
    private final String genderCode;
}
