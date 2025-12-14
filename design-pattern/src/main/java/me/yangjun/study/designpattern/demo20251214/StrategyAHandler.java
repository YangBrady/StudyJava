package me.yangjun.study.designpattern.demo20251214;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class StrategyAHandler implements StrategyHandler {
    @Override
    public String handle(String param) {
        return "哈哈哈" + param;
    }
}
