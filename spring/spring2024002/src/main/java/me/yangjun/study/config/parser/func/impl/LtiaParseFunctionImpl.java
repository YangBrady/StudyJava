package me.yangjun.study.config.parser.func.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.parser.func.ParseFunction;

@Service
@Slf4j
public class LtiaParseFunctionImpl implements ParseFunction {
    @Override
    public String functionName() {
        return "ltiaParseFunctionImpl";
    }

    @Override
    public String apply(String value) {
        log.info("handle by {}", this.functionName());
        return value + "----Before";
    }
}
