package me.yangjun.study.spring2025003.demo20251214.service.impl;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import me.yangjun.study.spring2025003.demo20251214.factory.StrategyFactory;
import me.yangjun.study.spring2025003.demo20251214.service.StrategyHandler;
import org.springframework.stereotype.Service;

@Service
@EqualsAndHashCode
@RequiredArgsConstructor
public class CommonStrategyHandler implements StrategyHandler {
    private final StrategyFactory strategyFactory;

    @Override
    public String handle(String param) {
        return strategyFactory.getStrategy(param).map(o -> (o.handle(param))).orElse("");
    }
}
