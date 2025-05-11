package me.yangjun.study.config.parser.operator.impl;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.parser.operator.IOperatorGetService;
import me.yangjun.study.vo.Operator;
import org.springframework.stereotype.Service;

/**
 * 默认操作人
 *
 * @author Brady
 * @date 2024/12/15
 */
@Service
@Slf4j
public class DefaultOperatorGetServiceImpl implements IOperatorGetService {
    @Override
    public Operator getUser() {
        Operator defaultOperator = new Operator();
        defaultOperator.setName("默认用户");
        defaultOperator.setAge(20);
        return defaultOperator;
    }
}
