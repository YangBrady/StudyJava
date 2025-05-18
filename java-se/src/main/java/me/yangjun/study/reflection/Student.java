package me.yangjun.study.reflection;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student extends People {
    private String stuId;

    @Override
    public String toString() {
        return "Student [stuId=" + stuId + "]";
    }
}
