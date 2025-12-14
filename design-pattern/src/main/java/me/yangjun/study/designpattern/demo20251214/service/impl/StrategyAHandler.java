package me.yangjun.study.designpattern.demo20251214.service.impl;

import lombok.EqualsAndHashCode;
import me.yangjun.study.designpattern.demo20251214.service.StrategyHandler;

@EqualsAndHashCode
public class StrategyAHandler implements StrategyHandler {
    @Override
    public String handle(String param) {
        return "哈哈哈" + param;
    }
}
