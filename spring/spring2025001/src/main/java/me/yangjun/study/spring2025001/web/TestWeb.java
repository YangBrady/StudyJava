package me.yangjun.study.spring2025001.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.ImmutableMap;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.spring2025001.dao.entity.EmployeeEntityVo;
import me.yangjun.study.spring2025001.service.EmployeeEntityService;

@RestController
@RequestMapping("test")
@Slf4j
public class TestWeb {
    @Autowired
    private EmployeeEntityService employeeEntityService;

    @GetMapping("sayHi/{word}")
    public String sayHi(@PathVariable("word") String word) {
        log.info("进入controller {}", word);
        QueryWrapper<EmployeeEntityVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(ImmutableMap.of("emp_no", 10002));
        List<EmployeeEntityVo> entityVoList = employeeEntityService.list(queryWrapper);
        return String.valueOf(entityVoList.size());
    }
}
