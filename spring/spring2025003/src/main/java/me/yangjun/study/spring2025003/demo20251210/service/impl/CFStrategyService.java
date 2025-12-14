package me.yangjun.study.spring2025003.demo20251210.service.impl;

import org.springframework.stereotype.Service;

import me.yangjun.study.spring2025003.demo20251210.service.GameStrategyService;

@Service
public class CFStrategyService implements GameStrategyService {
    @Override
    public String getGameName() {
        return "穿越火线";
    }
}
