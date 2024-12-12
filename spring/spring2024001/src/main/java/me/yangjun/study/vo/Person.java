package me.yangjun.study.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -935165524256768766L;
    private String name;
    private Integer age;
}
