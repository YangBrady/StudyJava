package me.yangjun.study.spring2025003.demo20251210.service.impl;

import org.springframework.stereotype.Service;

import me.yangjun.study.spring2025003.demo20251210.service.GameStrategyService;

@Service
public class LOLStrategyService implements GameStrategyService {
    @Override
    public String getGameName() {
        return "英雄联盟";
    }
}
