package me.yangjun.study.juc.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class LockSupportDemo {
    @Test
    @DisplayName("先park，再unpark")
    public void test01() throws InterruptedException {
        log.info("主线程开始运行");
        Thread t1 = new Thread(() -> {
            log.info("t1 准备");
            LockSupport.park();
            log.info("t1开始执行");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            }
            log.info("t1 结束");
        });

        t1.start();

        log.info("主线程 开始睡眠");
        TimeUnit.SECONDS.sleep(2);
        log.info("主线程 解锁t1");
        LockSupport.unpark(t1);
        log.info("主线程 over");
        // 主线程睡眠等待子线程执行完
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    @DisplayName("先unpark，再park")
    public void test02() throws InterruptedException {
        log.info("主线程开始运行");
        Thread t1 = new Thread(() -> {
            log.info("t1 准备");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            }
            LockSupport.park();
            log.info("t1 结束");
        });

        t1.start();

        log.info("主线程 解锁t1");
        LockSupport.unpark(t1);
        log.info("主线程 over");
        // 主线程睡眠等待子线程执行完
        TimeUnit.SECONDS.sleep(5);
    }
}
