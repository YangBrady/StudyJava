package me.yangjun.study.aop.xml;

public class AopSurface {

    public void begin() {
        System.out.println("开始事务");
    }

    public void close() {
        System.out.println("关闭事务");
    }

}