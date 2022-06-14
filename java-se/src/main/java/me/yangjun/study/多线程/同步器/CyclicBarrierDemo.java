package me.yangjun.study.多线程.同步器;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mooejun
 * @since 2020/04/16
 */
@Slf4j
public class CyclicBarrierDemo {
    // 创建 CyclicBarrier 实例，计数器的值设置为2，同时传入一个barrierAction
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> log.info("全都过屏障了"));

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int breakCount = 0;

        // 将线程提交到线程池
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                log.info(Thread.currentThread() + "到达第1层屏障");
                cyclicBarrier.await();

                Thread.sleep(2000);
                log.info(Thread.currentThread() + "到达第2层屏障");
                cyclicBarrier.await();

                log.info(Thread.currentThread() + "终点");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                log.info(Thread.currentThread() + "到达第1层屏障");
                cyclicBarrier.await();

                Thread.sleep(1000);
                log.info(Thread.currentThread() + "到达第2层屏障");
                cyclicBarrier.await();

                log.info(Thread.currentThread() + "终点");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}