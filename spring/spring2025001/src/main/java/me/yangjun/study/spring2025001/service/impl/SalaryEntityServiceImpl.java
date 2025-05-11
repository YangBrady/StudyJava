package me.yangjun.study.spring2025001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.yangjun.study.spring2025001.dao.entity.SalaryEntityVo;
import me.yangjun.study.spring2025001.service.SalaryEntityService;
import me.yangjun.study.spring2025001.dao.mapper.SalaryEntityMapper;
import org.springframework.stereotype.Service;

/**
* @author Brady
* @description 针对表【salaries】的数据库操作Service实现
* @createDate 2025-05-04 11:13:20
*/
@Service
public class SalaryEntityServiceImpl extends ServiceImpl<SalaryEntityMapper, SalaryEntityVo>
    implements SalaryEntityService{

}




