package me.yangjun.modules.frame.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mooejun
 * @since 2019/09/03
 */
public class RateLimiterExample {

    public static void main(String[] args) throws InterruptedException {

        // 平滑突发模式, 以每秒生成n令牌速度存储令牌
        RateLimiter rateLimiter = RateLimiter.create(0.5);
        // 平滑预热模式模式, 逐渐加快发放令牌速度到平滑突发模式
        // RateLimiter rateLimiter = RateLimiter.create(5, 1000, TimeUnit.MILLISECONDS);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int nTasks = 10;
        CountDownLatch countDownLatch = new CountDownLatch(nTasks);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= nTasks; i++) {
            final int j = i;
            executorService.submit(() -> {
                System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start ");
                rateLimiter.acquire(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(
                    System.currentTimeMillis() + Thread.currentThread().getName() + " gets job " + j + " done");
                countDownLatch.countDown();
            });
        }
        executorService.shutdown();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("10 jobs gets done by 5 threads concurrently in " + (end - start) + " milliseconds");

    }
}