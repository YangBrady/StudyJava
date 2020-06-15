package me.yangjun.study.单例模式;

/**
 * 懒汉式（线程不安全）
 */
public class SingletonDemo001 {
    private static SingletonDemo001 singletonDemo001;

    private SingletonDemo001() {
    }

    public static SingletonDemo001 getInstance() {
        if (singletonDemo001 == null) {
            singletonDemo001 = new SingletonDemo001();
        }
        return singletonDemo001;
    }
}
