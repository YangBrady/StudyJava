package me.yangjun.study.designpattern.demo20251214;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StrategyFactory {
    private static final Map<StrategySelector, StrategyHandler> strategyMap = new HashMap<>();

    static {
        strategyMap.put(new StrategyASelector(), new StrategyAHandler());
        strategyMap.put(new StrategyBSelector(), new StrategyBHandler());
    }

    public static Optional<StrategyHandler> getStrategy(String param) {
        for (Map.Entry<StrategySelector, StrategyHandler> entry : strategyMap.entrySet()) {
            if (entry.getKey().match(param)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<StrategyHandler> opt = StrategyFactory.getStrategy("B");
        opt.ifPresent(o -> System.out.println(o.handle("QQQ")));

    }
}
