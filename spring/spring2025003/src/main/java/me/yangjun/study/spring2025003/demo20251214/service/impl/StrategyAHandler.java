package me.yangjun.study.spring2025003.demo20251214.service.impl;

import lombok.EqualsAndHashCode;
import me.yangjun.study.spring2025003.demo20251214.service.StrategyHandler;
import org.springframework.stereotype.Service;

@Service
@EqualsAndHashCode
public class StrategyAHandler implements StrategyHandler {

    @Override
    public String handle(String param) {
        return "哈哈哈" + param;
    }
}
