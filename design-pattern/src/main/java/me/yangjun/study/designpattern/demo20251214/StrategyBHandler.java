package me.yangjun.study.designpattern.demo20251214;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class StrategyBHandler implements StrategyHandler {
    @Override
    public String handle(String param) {
        return "嘿嘿嘿" + param;
    }
}
