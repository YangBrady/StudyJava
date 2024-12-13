package me.yangjun.study.juc.executor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExecutorTest {
    @Test
    void testExecuteError() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(2, 5, 1, TimeUnit.DAYS, new LinkedBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardPolicy());

        threadPoolExecutor.prestartCoreThread();

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(() -> log.info("ok"));
        }

        TimeUnit.SECONDS.sleep(2);

        threadPoolExecutor.execute(() -> {
            // 执行的线程会被销毁
            throw new RuntimeException("nonononono");
        });

        TimeUnit.SECONDS.sleep(2);

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(() -> log.info("ok2"));
        }
    }

    @Test
    void testSubmitError() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(2, 5, 1, TimeUnit.DAYS, new LinkedBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardPolicy());

        threadPoolExecutor.prestartCoreThread();

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(() -> log.info("ok"));
        }

        TimeUnit.SECONDS.sleep(2);

        threadPoolExecutor.submit(() -> {
            // 线程继续复用
            throw new RuntimeException("nonononono");
        });

        TimeUnit.SECONDS.sleep(2);

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(() -> log.info("ok2"));
        }
    }

    @Test
    @DisplayName("获取提交任务的堆栈信息")
    void test003() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2, 5, 1, TimeUnit.DAYS, new LinkedBlockingQueue<>(10),
                        new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.prestartCoreThread();
        // 异常会被吞掉
        // threadPoolExecutor.submit(() -> log.info(String.valueOf(10/2)));
        // threadPoolExecutor.submit(() -> log.info(String.valueOf(0/1)));
        // threadPoolExecutor.submit(() -> log.info(String.valueOf(10/0)));
        // threadPoolExecutor.submit(() -> log.info(String.valueOf(5/2)));
        // threadPoolExecutor.submit(() -> log.info(String.valueOf(1/2)));

        // 异常会打印出来
        threadPoolExecutor.execute(() -> log.info(String.valueOf(10/2)));
        threadPoolExecutor.execute(() -> log.info(String.valueOf(0/1)));
        threadPoolExecutor.execute(() -> log.info(String.valueOf(10/0)));
        threadPoolExecutor.execute(() -> log.info(String.valueOf(5/2)));
        threadPoolExecutor.execute(() -> log.info(String.valueOf(1/2)));

        TimeUnit.SECONDS.sleep(3);
    }
}
