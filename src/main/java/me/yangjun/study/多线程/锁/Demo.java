package me.yangjun.study.多线程.锁;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class Demo {
    public static void main(String[] args) {
        Demo.testSynchronized();
        // Demo.testBiasedLock();
    }

    // 测试 synchronized 对于 锁的影响
    public static void testSynchronized() {
        Object o = new Object();
        log.debug(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            log.debug(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    // 测试 偏向锁
    public static void testBiasedLock() {
        Object o = new Object();
        log.debug(ClassLayout.parseInstance(o).toPrintable());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object o2 = new Object();
        log.debug(ClassLayout.parseInstance(o2).toPrintable());
    }
}
