package me.yangjun.study.designpattern.demo20251214.service.impl;

import lombok.EqualsAndHashCode;
import me.yangjun.study.designpattern.demo20251214.service.StrategySelector;

@EqualsAndHashCode
public class StrategyASelector implements StrategySelector {
    @Override
    public boolean match(String param) {
        return "A".equalsIgnoreCase(param);
    }
}
