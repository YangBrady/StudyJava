package me.yangjun.study.config.parser.spel;

import java.lang.reflect.Method;
import java.util.Collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.expression.EvaluationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.parser.func.FunctionService;

@Component
@Slf4j
public class AutoLogValueParser {
    @Autowired
    private AutoLogExpressionEvaluator expEvaluator;
    @Autowired
    private FunctionService functionService;

    public String parse(Method method, Object[] args,
                        Object target, Class<?> targetClass, Method targetMethod, @Nullable Object result, String errorMsg,
                        @Nullable BeanFactory beanFactory) {
        // this.createEvaluationContext(null, null);
        return null;
    }

    public EvaluationContext createEvaluationContext(Method method, Object[] args,
        Object target, Class<?> targetClass, Method targetMethod, @Nullable Object result, String errorMsg,
        @Nullable BeanFactory beanFactory) {
        return expEvaluator.createEvaluationContext(method, args, targetClass, result, errorMsg, beanFactory);
    }

}