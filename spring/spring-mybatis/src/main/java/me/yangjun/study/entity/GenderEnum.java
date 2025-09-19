package me.yangjun.study.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderEnum {
    FEMALE("女性", "F"),
    MALE("男性", "M")
    ;

    private final String genderZhName;

    private final String genderCode;

    public static GenderEnum getByCode(String code) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.genderCode.equals(code)) {
                return genderEnum;
            }
        }
        return null;
    }
}
