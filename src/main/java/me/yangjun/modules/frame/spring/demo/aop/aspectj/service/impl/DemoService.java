package me.yangjun.modules.frame.spring.demo.aop.aspectj.service.impl;

import me.yangjun.modules.frame.spring.demo.aop.aspectj.service.IDemoService;

/**
 * @author mooejun
 * @since 2020/04/24
 */
public class DemoService implements IDemoService {

    @Override
    public void show() {
        System.out.println("==========show");
    }

    @Override
    public boolean showWithArgs(String arg1, int arg2) {
        System.out.println("==========showWithArgs");
        return false;
    }

    @Override
    public boolean showWithException(String arg1, int arg2) {
        System.out.println(1 / 0);
        System.out.println("==========showWithException");
        return false;
    }
}
