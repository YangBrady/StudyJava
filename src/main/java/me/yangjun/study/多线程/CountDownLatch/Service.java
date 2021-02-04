package me.yangjun.study.多线程.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Service {
    private CountDownLatch latch;

    Service(CountDownLatch latch) {
        this.latch = latch;
    }

    void exec() {
        try {
            log.info(Thread.currentThread().getName() + " working. ");
            sleep(2);
            log.info(Thread.currentThread().getName() + " end. ");
        } finally {
            latch.countDown();
        }
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
