package me.yangjun.study.designpattern.create.singleton;

/**
 * 懒惰单例 - 线程不安全
 *
 * @author mooejun
 * @date 2023/07/11
 */
public class LazySingletonDemo1 {
    private static LazySingletonDemo1 instance;

    private LazySingletonDemo1() {
    }

    public static LazySingletonDemo1 getInstance() {
        if (instance == null) {
            instance = new LazySingletonDemo1();
        }

        return instance;
    }
}