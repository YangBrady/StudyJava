package me.yangjun.study.spring2025003.demo20251214.factory;


import lombok.RequiredArgsConstructor;
import me.yangjun.study.spring2025003.demo20251214.service.StrategyHandler;
import me.yangjun.study.spring2025003.demo20251214.service.StrategySelector;
import me.yangjun.study.spring2025003.demo20251214.service.impl.StrategyAHandler;
import me.yangjun.study.spring2025003.demo20251214.service.impl.StrategyASelector;
import me.yangjun.study.spring2025003.demo20251214.service.impl.StrategyBHandler;
import me.yangjun.study.spring2025003.demo20251214.service.impl.StrategyBSelector;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StrategyFactory {
    private static final Map<StrategySelector, StrategyHandler> strategyMap = new HashMap<>();

    @PostConstruct
    public void init() {
        strategyMap.put(new StrategyASelector(), new StrategyAHandler());
        strategyMap.put(new StrategyBSelector(), new StrategyBHandler());
    }

    public Optional<StrategyHandler> getStrategy(String param) {
        for (Map.Entry<StrategySelector, StrategyHandler> entry : strategyMap.entrySet()) {
            if (entry.getKey().match(param)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
}
