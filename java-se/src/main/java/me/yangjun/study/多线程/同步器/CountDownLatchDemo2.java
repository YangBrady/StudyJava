package me.yangjun.study.多线程.同步器;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mooejun
 * @since 2022/6/1 17:33
 */
@Slf4j
public class CountDownLatchDemo2 {
    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("Thread-1 执行完毕");
                countDownLatch.countDown();
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("Thread-2 执行完毕");
                countDownLatch.countDown();
            }
        });

        log.info("主线程等待子线程执行完毕");
        log.info("计数器值为：" + countDownLatch.getCount());
        countDownLatch.await();
        log.info("计数器值为：" + countDownLatch.getCount());
        log.info("主线程执行完毕");
        executorService.shutdown();
    }
}
