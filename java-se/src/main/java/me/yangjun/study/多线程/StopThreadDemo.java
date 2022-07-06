package me.yangjun.study.多线程;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class StopThreadDemo {

    public volatile boolean exit = false;

    public static void main(String[] args) throws InterruptedException {
        StopThreadDemo stopThreadDemo = new StopThreadDemo();
        // stopThreadDemo.shareVar();
        // stopThreadDemo.interrupt();
        stopThreadDemo.cantInterrupt();
    }

    /**
     * 通过共享变量实现
     *
     * @throws InterruptedException
     */
    public void shareVar() throws InterruptedException {
        new Thread(() -> {
            log.info("开启线程");
            while (!exit) {
                log.info(String.valueOf(exit));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("退出线程");
        }).start();

        TimeUnit.SECONDS.sleep(5);
        exit = true;
    }

    public void interrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("开启线程");
            log.info(String.valueOf(Thread.currentThread().isInterrupted()));
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("退出线程");
        });

        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
        log.info(String.valueOf(thread.isInterrupted()));
    }

    public void cantInterrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("开启线程");
            log.info(String.valueOf(Thread.currentThread().isInterrupted()));
            while (true) {
                log.info("JOJO 我停不下来啦~~~");
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
    }
}
