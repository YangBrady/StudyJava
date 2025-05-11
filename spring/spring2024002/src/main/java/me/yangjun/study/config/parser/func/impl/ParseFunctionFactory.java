package me.yangjun.study.config.parser.func.impl;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.parser.func.ParseFunction;

@Slf4j
@Component
public class ParseFunctionFactory implements ApplicationContextAware {
    private Map<String, ParseFunction> allFunctionMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        allFunctionMap = applicationContext.getBeansOfType(ParseFunction.class);
    }

    public ParseFunction getFunction(String functionName) {
        return allFunctionMap.get(functionName);
    }
}