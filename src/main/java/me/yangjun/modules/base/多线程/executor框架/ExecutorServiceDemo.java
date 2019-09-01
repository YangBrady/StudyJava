package me.yangjun.modules.base.多线程.executor框架;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mooejun
 * @since 2019/08/09
 */
public class ExecutorServiceDemo {

    @Test
    public void exeRunable() {
        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // ExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            executorService.execute(new TestRunable());
            System.out.println("********** call times:" + i + "**********");
        }
        executorService.shutdown();
    }

    @Test
    public void exeCallable() {
        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // ExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            executorService.execute(new TestRunable());
            System.out.println("********** call times:" + i + "**********");
        }
        executorService.shutdown();
    }
}

class TestRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行被调用了");
    }
}

class TestCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}
