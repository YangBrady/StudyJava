package me.yangjun.study.spring2025003.service.impl;

import org.springframework.stereotype.Service;

import me.yangjun.study.spring2025003.service.GameStrategyService;

@Service
public class PubgStrategyService implements GameStrategyService {
    @Override
    public String getGameName() {
        return "绝地求生";
    }
}
