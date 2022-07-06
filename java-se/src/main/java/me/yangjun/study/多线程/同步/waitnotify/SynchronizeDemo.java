package me.yangjun.study.多线程.同步.waitnotify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SynchronizeDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new DealThreadA(lock), "wait进程");
        Thread t2 = new Thread(new DealThreadB(lock), "notify进程");
        t2.start();
        Thread.sleep(50);
        t1.start();
    }
}

@Slf4j
@Data
class DealObj {
    public static List<String> dealList = new ArrayList<>();

    public static void addData() {
        dealList.add("嘿嘿");
    }

    public static int size() {
        return dealList.size();
    }
}

@Slf4j
@Data
@AllArgsConstructor
class DealThreadA implements Runnable {
    private Object lock;

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                DealObj.addData();
                log.info("数量+1，当前数量=" + DealObj.size());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (DealObj.size() == 5) {
                    lock.notify();
                }
            }
        }
    }
}

@Slf4j
@Data
@AllArgsConstructor
class DealThreadB implements Runnable {
    private Object lock;

    @Override
    public void run() {
        try {
            synchronized (lock) {
                log.info("当前数量=" + DealObj.size());
                if (DealObj.size() != 5) {
                    log.info("wait begin " + System.currentTimeMillis());
                    lock.wait();
                    log.info("wait end " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
