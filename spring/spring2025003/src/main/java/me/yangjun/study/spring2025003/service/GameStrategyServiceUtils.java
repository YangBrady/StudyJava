package me.yangjun.study.spring2025003.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GameStrategyServiceUtils {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private List<GameStrategyService> strategyServiceList;

    public void printAllGameName() {
        Map<String, GameStrategyService> beanNameToServiceMap =
            applicationContext.getBeansOfType(GameStrategyService.class);
        for (Map.Entry<String, GameStrategyService> entry : beanNameToServiceMap.entrySet()) {
            log.info("gameName={}", entry.getValue().getGameName());
        }
    }

    public void printAllGameName2() {
        for (GameStrategyService gameStrategyService : strategyServiceList) {
            log.info("gameName={}", gameStrategyService.getGameName());
        }
    }
}
