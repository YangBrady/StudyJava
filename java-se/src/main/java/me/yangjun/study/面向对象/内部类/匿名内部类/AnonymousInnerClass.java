package me.yangjun.study.面向对象.内部类.匿名内部类;

import org.junit.jupiter.api.Test;

/**
 * JDK1.8以前，匿名内部类调用的局部变量必须是final修饰的。
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
