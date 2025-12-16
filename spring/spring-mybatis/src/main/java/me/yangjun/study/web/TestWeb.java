package me.yangjun.study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.entity.Employee;
import me.yangjun.study.service.EmployeeService;

@RestController
@RequestMapping("test")
@Slf4j
public class TestWeb {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("sayHi/{id}")
    public String sayHi(@PathVariable("id") Long id) {
        log.info("进入controller {}", id);
        Employee employee = employeeService.getById(id);
        return employee.getFirstName() + employee.getLastName();
    }
}
