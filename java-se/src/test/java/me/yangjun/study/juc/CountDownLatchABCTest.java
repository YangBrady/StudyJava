package me.yangjun.study.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 用CountDownLatch实现线程有序性
 *
 * @author yangjun
 */
@Slf4j
public class CountDownLatchABCTest {
    @Test
    public void abc() {
        Thread t1 = new Thread(() -> log.info("A"));
        Thread t2 = new Thread(() -> log.info("B"));
        Thread t3 = new Thread(() -> log.info("C"));

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void sortAbc() {
        CountDownLatch cdlForAOver = new CountDownLatch(1);
        CountDownLatch cdlForBOver = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            log.info("A");
            cdlForAOver.countDown();
        });

        Thread t2 = new Thread(() -> {
            try {
                cdlForAOver.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("B");
            cdlForBOver.countDown();
        });

        Thread t3 = new Thread(() -> {
            try {
                cdlForBOver.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("C");

        });

        t3.start();
        t2.start();
        t1.start();
    }
}