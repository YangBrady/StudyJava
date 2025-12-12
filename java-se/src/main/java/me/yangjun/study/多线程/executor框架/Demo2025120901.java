package me.yangjun.study.多线程.executor框架;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * -Xmx10m -Xms10m
 */
public class Demo2025120901 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1),
                new MyThreadFactory("MyTF"),
                new DiscardPolicy());


        // 模拟外部请求
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            new Thread(() -> {
                List<Future<Integer>> futures = new CopyOnWriteArrayList<>();
                for (int i = 0; i < 5; i++) {
                    int finalI = i;
                    Future<Integer> future = pool.submit(() -> finalI * 10);
                    futures.add(future);
                }

                for (Future<Integer> future : futures) {
                    try {
                        // pool.submit后出发拒绝策略，但是没有抛出异常，future状态一直是NEW，导致无法get
                        System.out.println(future.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("遍历结束");
            }).start();
        }
    }

    // @Slf4j
    private static class MyPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("-- 自定义拒绝策略，不处理 --");
            throw new RejectedExecutionException("Task " + r.toString() + "rejected from " + executor.toString());
        }
    }

    /**
     * 基于 Executors.defaultThreadFactory() 增加了一个前缀
     */
    static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory(String threadNamePrefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = threadNamePrefix + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
