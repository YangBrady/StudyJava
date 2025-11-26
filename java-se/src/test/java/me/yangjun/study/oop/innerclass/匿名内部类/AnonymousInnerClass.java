package me.yangjun.study.oop.innerclass.匿名内部类;

import org.junit.jupiter.api.Test;

/**
 * 匿名内部类
 *
 * @author mooejun
 * @since 2019/3/18
 */
public class AnonymousInnerClass {

    @Test
    public void demo01() {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("哈哈");
            }
        };

        t.start();
    }

    @Test
    public void demo02() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("哼哼");
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
