package me.yangjun.study.designpattern.demo20251214;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class StrategyBSelector implements StrategySelector {
    @Override
    public boolean match(String param) {
        return "B".equalsIgnoreCase(param);
    }
}
