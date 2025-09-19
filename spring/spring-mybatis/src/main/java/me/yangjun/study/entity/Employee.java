package me.yangjun.study.entity;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @TableName employees
 */
@Data
public class Employee {
    /**
     * 
     */
    private Integer empNo;

    /**
     * 
     */
    private Date birthDate;

    /**
     * 
     */
    private String firstName;

    /**
     * 
     */
    private String lastName;

    /**
     * 
     */
    private GenderEnum gender;

    /**
     * 
     */
    private Date hireDate;
}