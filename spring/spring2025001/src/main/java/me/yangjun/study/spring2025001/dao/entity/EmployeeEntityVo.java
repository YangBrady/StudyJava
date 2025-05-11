package me.yangjun.study.spring2025001.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
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