package me.yangjun.study.designpattern.create.singleton;

/**
 * 双重校验锁
 *
 * @author Brady
 * @date 2023/07/11
 */
public class DoubleCheckLockSingletonDemo {
    private volatile static DoubleCheckLockSingletonDemo INSTANCE;

    private DoubleCheckLockSingletonDemo() {
    }

    public static DoubleCheckLockSingletonDemo getSingleton() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLockSingletonDemo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLockSingletonDemo();
                }
            }
        }

        return INSTANCE;
    }
}