package me.yangjun.modules.frame.spring.demo.aop.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 声明切面
 *
 * @author mooejun
 * @since 2020/04/23
 */
@Aspect
public class LogAspect {

    /**
     * 声明切点
     */
    @Pointcut("execution(* me.yangjun.modules.frame.spring.demo.aop.aspectj.service..*.show(..))")
    public void pShow() {}

    @Pointcut(
        value = "execution(* me.yangjun.modules.frame.spring.demo.aop.aspectj.service..*.showWithArgs(..)) && args(p1, p2)",
        argNames = "p1, p2")
    public void pShowWithArgs(String p1, int p2) {}

    @Pointcut(
        value = "execution(* me.yangjun.modules.frame.spring.demo.aop.aspectj.service..*.showWithException(..)) && args(p1, p2)",
        argNames = "p1, p2")
    public void pShowWithException(String p1, int p2) {}

    /**
     * 声明通知
     */
    @Before("pShow()")
    public void before() {
        System.out.println("before");
    }

    @Before(value = "pShowWithArgs(p1, p2)", argNames = "p1, p2")
    public void before(String p1, int p2) {
        System.out.println("before" + ", p1=" + p1 + ", p2=" + p2);
    }

    @AfterReturning(value = "pShowWithArgs(p1, p2)", argNames = "p1, p2")
    public void afterReturning(String p1, int p2) {
        System.out.println("afterReturning" + ", p1=" + p1 + ", p2=" + p2);
    }

    @After(value = "pShowWithArgs(p1, p2)", argNames = "p1, p2")
    public void after(String p1, int p2) {
        System.out.println("after" + ", p1=" + p1 + ", p2=" + p2);
    }

    @AfterThrowing(value = "pShowWithException(p1, p2)", argNames = "p1, p2")
    public void afterThrowing(String p1, int p2) {
        System.out.println("afterThrowing");
    }

    @Around(value = "pShowWithArgs(p1, p2)", argNames = "joinPoint, p1, p2")
    public Object after(ProceedingJoinPoint joinPoint, String p1, int p2) throws Throwable {
        System.out.println("AroundAfterThrowing1");
        Object obj = joinPoint.proceed();
        System.out.println("AroundAfterThrowing2 return:" + obj);
        return obj;
    }

    @Around(value = "pShowWithException(p1, p2)", argNames = "joinPoint, p1, p2")
    public Object afterThrowing(ProceedingJoinPoint joinPoint, String p1, int p2) throws Throwable {
        System.out.println("AroundAfterThrowing1");
        Object obj = joinPoint.proceed();
        System.out.println("AroundAfterThrowing2 return:" + obj);
        return obj;
    }
}
