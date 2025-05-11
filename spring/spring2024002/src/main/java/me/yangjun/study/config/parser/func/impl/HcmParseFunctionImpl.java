package me.yangjun.study.config.parser.func.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import me.yangjun.study.config.parser.func.ParseFunction;

@Service
@Slf4j
public class HcmParseFunctionImpl implements ParseFunction {
    @Override
    public String functionName() {
        return "hcmParseFunctionImpl";
    }

    @Override
    public String apply(String value) {
        log.info("handle by {}", this.functionName());
        return value + "----After";
    }
}
