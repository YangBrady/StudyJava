package me.yangjun.study.spring2025003.demo20251214.service.impl;

import lombok.EqualsAndHashCode;
import me.yangjun.study.spring2025003.demo20251214.service.StrategyHandler;
import org.springframework.stereotype.Service;

@Service
@EqualsAndHashCode
public class StrategyBHandler implements StrategyHandler {
    @Override
    public String handle(String param) {
        return "嘿嘿嘿" + param;
    }
}
