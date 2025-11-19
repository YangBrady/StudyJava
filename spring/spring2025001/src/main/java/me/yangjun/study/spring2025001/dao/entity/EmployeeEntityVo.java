package me.yangjun.study.spring2025001.dao.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 
 * @TableName employees
 */
@TableName(value ="employees")
@Data
public class EmployeeEntityVo {
    /**
     * 
     */
    @TableId
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