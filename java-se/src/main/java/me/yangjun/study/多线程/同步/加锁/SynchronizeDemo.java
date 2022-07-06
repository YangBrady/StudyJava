package me.yangjun.study.多线程.同步.加锁;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * synchronize by lock
 */
public class SynchronizeDemo {
    public static void main(String[] args) {
        DealObj dealObj = new DealObj();
        // run first
        Thread t1 = new Thread(new DealThreadA(dealObj));
        // run last
        Thread t2 = new Thread(new DealThreadB(dealObj));
        t1.start();
        t2.start();
    }
}

@Slf4j
class DealObj {
    synchronized void add() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("增加一个");
    }

    synchronized void print() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("输出结果");
    }
}

@Slf4j
@Data
@AllArgsConstructor
class DealThreadA implements Runnable {
    private DealObj dealObj;

    @Override
    public void run() {
        dealObj.add();
    }
}

@Slf4j
@Data
@AllArgsConstructor
class DealThreadB implements Runnable {
    private DealObj dealObj;

    @Override
    public void run() {
        dealObj.print();
    }
}