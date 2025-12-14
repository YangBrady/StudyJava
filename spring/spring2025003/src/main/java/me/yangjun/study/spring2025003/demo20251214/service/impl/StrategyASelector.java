package me.yangjun.study.spring2025003.demo20251214.service.impl;

import lombok.EqualsAndHashCode;
import me.yangjun.study.spring2025003.demo20251214.service.StrategySelector;
import org.springframework.stereotype.Service;

@Service
@EqualsAndHashCode
public class StrategyASelector implements StrategySelector {
    @Override
    public boolean match(String param) {
        return "A".equalsIgnoreCase(param);
    }
}
