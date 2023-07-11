package me.yangjun.study.designpattern.create.singleton;

/**
 * 懒惰单例 - 线程安全，效率低
 *
 * @author mooejun
 * @date 2023/07/11
 */
public class LazySingletonDemo2 {
    private static LazySingletonDemo2 instance;

    private LazySingletonDemo2() {
    }

    public static synchronized LazySingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new LazySingletonDemo2();
        }

        return instance;
    }
}