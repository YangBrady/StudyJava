package me.yangjun.study.config.aop;

import java.lang.reflect.Method;

import me.yangjun.study.config.parser.spel.AutoLogValueParser;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.parser.func.ParseFunction;
import me.yangjun.study.config.parser.func.impl.ParseFunctionFactory;

@Aspect
@Component
@Slf4j
public class LogRecordAspect {
    @Autowired
    private ParseFunctionFactory parseFunctionFactory;
    @Autowired
    private AutoLogValueParser autoLogValueParser;

    /**
     * 切点
     */
    @Pointcut("@annotation(me.yangjun.study.config.aop.LogRecord)")
    public void logRecordPointCut() {}

    @Around("logRecordPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("进入切面");
        // 方法名称
        String methodName = joinPoint.getSignature().getName();
        // 方法传入参数
        Object[] params = joinPoint.getArgs();
        // 方法注解
        LogRecord logRecord = getDeclaredAnnotation(joinPoint);

        // 执行
        Object ret = joinPoint.proceed();


        // 解析日志
        // autoLogValueParser.createEvaluationContext();
        String function = StringUtils.isBlank(logRecord.success()) ? "hcmParseFunctionImpl" : logRecord.success();
        ParseFunction parseFunction = parseFunctionFactory.getFunction(function);
        String parseResult = parseFunction.apply(logRecord.detail());
        // 记录日志
        log.info("logRecord：{}", parseResult);

        return ret;
    }

    /**
     * 获取方法中声明的注解
     *
     * @param joinPoint joinPoint
     * @return 注解实例
     */
    private static LogRecord getDeclaredAnnotation(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 反射获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 拿到方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();
        // 根据类、方法、参数类型（重载）获取到方法的具体信息
        Method objMethod = targetClass.getMethod(methodName, parameterTypes);
        // 拿到方法定义的注解信息
        return objMethod.getDeclaredAnnotation(LogRecord.class);
    }
}
