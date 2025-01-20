package me.yangjun.study.config.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogRecordAspect {
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

        // TODO 记录日志

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
