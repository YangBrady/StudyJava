package me.yangjun.modules.frame.spring.demo.aop.aspectj.service;

public interface IDemoService {
    void show();

    boolean showWithArgs(String arg1, int arg2);

    boolean showWithException(String arg1, int arg2);
}
