package me.yangjun.study.springtest;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Slf4j
public class ExecutorDemo001 {
    public static final ThreadLocal<String> TL = new ThreadLocal<>();

    public void foo() {
        ThreadPoolTaskExecutor springPool = new ThreadPoolTaskExecutor();
        springPool.setCorePoolSize(1);
        springPool.setMaxPoolSize(2);
        springPool.setKeepAliveSeconds(1000);
        springPool.setQueueCapacity(10);
        springPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        springPool.setTaskDecorator(runnable -> {
            String currentThreadName = getCurrentThreadName();
            String tl = TL.get();
            return () -> {
                try {
                    TL.set(tl);
                    runnable.run();
                } catch (Exception e) {
                    log.error("decorate ctx...", e);
                } finally {
                    if (!getCurrentThreadName().equals(currentThreadName)) {
                        TL.remove();
                    }
                }
            };
        });
        springPool.initialize();

        TL.set("aaa");

        for (int i = 0; i < 100; i++) {
            springPool.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("{}---{}", Thread.currentThread().getName(), TL.get());
            });
        }

        log.info(String.valueOf(TL));
    }

    public static String getCurrentThreadName() {
        Thread currentThread = Thread.currentThread();
        return currentThread.getThreadGroup().getName() + "-" + currentThread.getName() + "-" + currentThread.getId();
    }

    public static void main(String[] args) {
        new ExecutorDemo001().foo();
    }
}
