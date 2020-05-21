package me.yangjun.modules.frame.spring.demo.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect // 指定为切面类
public class AopSurface {

    // 前置通知 : 在执行目标方法之前执行
    @Before("execution(* me.yangjun.modules.frame.spring.demo.aop.annotation.*.*(..))")
    public void begin() {
        System.out.println("开始事务");
    }

    // 后置/最终通知：在执行目标方法之后执行 【无论是否出现异常最终都会执行】
    @After("execution(* me.yangjun.modules.frame.spring.demo.aop.annotation.*.*(..))")
    public void close() {
        System.out.println("关闭事务");
    }

    // 指定切入点表达式，拦截哪个类的哪些方法
    @Pointcut("execution(* me.yangjun.modules.frame.spring.demo.aop.annotation.*.*(..))")
    public void pt() {

    }

    // 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
    @AfterReturning("pt()")
    public void afterReturning() {
        System.out.println("afterReturning()");
    }

    // 异常通知： 当目标方法执行异常时候执行此关注点代码
    @AfterThrowing("pt()")
    public void afterThrowing() {
        System.out.println("afterThrowing()");
    }

    // 环绕通知：环绕目标方式执行
    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前....");
        pjp.proceed(); // 执行目标方法
        System.out.println("环绕后....");
    }
}