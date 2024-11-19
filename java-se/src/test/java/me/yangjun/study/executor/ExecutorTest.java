package me.yangjun.study.executor;

import lombok.extern.slf4j.Slf4j;
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
}
