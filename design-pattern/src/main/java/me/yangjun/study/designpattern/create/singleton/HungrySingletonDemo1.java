package me.yangjun.study.designpattern.create.singleton;

/**
 * 饿汉式<br>
 * <pre>
 *     这种方式基于classloader机制避免了多线程的同步问题
 *     不过，instance在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用getInstance方法，
 *     但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance显然没有达到lazy loading的效果。
 * </pre>
 */
public class HungrySingletonDemo1 {
    private static final HungrySingletonDemo1 INSTANCE = new HungrySingletonDemo1();

    private HungrySingletonDemo1() {
    }

    public static HungrySingletonDemo1 getInstance() {
        return INSTANCE;
    }
}