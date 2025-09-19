package me.yangjun.study.mapper;

import java.util.Optional;

import me.yangjun.study.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {
    Optional<Employee> selectByPrimaryKey(Long id);
}
