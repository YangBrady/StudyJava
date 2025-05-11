package me.yangjun.study.spring2025001.dao.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 
 * @TableName salaries
 */
@TableName(value = "salaries")
@Data
public class SalaryEntityVo {
    @TableId
    private Integer empNo;
    private Date fromDate;
    private Integer salary;
    private Date toDate;
}