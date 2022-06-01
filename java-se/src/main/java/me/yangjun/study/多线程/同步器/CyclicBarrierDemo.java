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
    // 创建 CyclicBarrier 实例，计数器的值设置为2
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> log.info("全部运行结束"));

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int breakCount = 0;

        // 将线程提交到线程池
        executorService.submit(() -> {
            try {
                log.info(Thread.currentThread() + "第一回合");
                Thread.sleep(1000);
                cyclicBarrier.await();

                log.info(Thread.currentThread() + "第二回合");
                Thread.sleep(2000);
                cyclicBarrier.await();

                log.info(Thread.currentThread() + "第三回合");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                log.info(Thread.currentThread() + "第一回合");
                Thread.sleep(2000);
                cyclicBarrier.await();

                log.info(Thread.currentThread() + "第二回合");
                Thread.sleep(1000);
                cyclicBarrier.await();

                log.info(Thread.currentThread() + "第三回合");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}