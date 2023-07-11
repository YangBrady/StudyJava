package me.yangjun.study.designpattern.create.singleton;

/**
 * 饿汉变种<br>
 */
public class HungrySingletonDemo2 {
    private static HungrySingletonDemo2 INSTANCE;

    static {
        INSTANCE = new HungrySingletonDemo2();
    }

    private HungrySingletonDemo2() {
    }

    public static HungrySingletonDemo2 getInstance() {
        return INSTANCE;
    }
}