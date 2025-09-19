package me.yangjun.study.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.entity.Employee;
import me.yangjun.study.mapper.EmployeeMapper;
import me.yangjun.study.service.EmployeeService;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getById(Long id) {
        Optional<Employee> employee = employeeMapper.selectByPrimaryKey(id);
        log.info("employee={}", employee);
        return employee.orElse(new Employee());
    }
}
