package me.yangjun.study.创造型.单例模式;

/**
 * 懒汉式，线程安全，效率低
 */
public class SingletonDemo002 {
    private static SingletonDemo002 singletonDemo002;

    private SingletonDemo002() {
    }

    public static synchronized SingletonDemo002 getInstance() {
        if (singletonDemo002 == null) {
            singletonDemo002 = new SingletonDemo002();
        }
        return singletonDemo002;
    }
}
