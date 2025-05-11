package me.yangjun.study.spring2025001.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import me.yangjun.study.spring2025001.dao.entity.EmployeeEntityVo;
import me.yangjun.study.spring2025001.dao.mapper.EmployeeEntityMapper;
import me.yangjun.study.spring2025001.service.EmployeeEntityService;

/**
 * @author Brady
 * @description 针对表【employees】的数据库操作Service实现
 * @createDate 2025-05-04 11:13:20
 */
@Service
public class EmployeeEntityServiceImpl extends ServiceImpl<EmployeeEntityMapper, EmployeeEntityVo>
    implements EmployeeEntityService {}
