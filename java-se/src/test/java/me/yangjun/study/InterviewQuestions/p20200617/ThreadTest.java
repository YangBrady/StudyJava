package me.yangjun.study.InterviewQuestions.p20200617;

import java.util.concurrent.TimeUnit;

/**
 * @author mooejun
 * @since 2020/6/17 2:24 下午
 */
public class ThreadTest {

    public static void main(String[] args) {
        new MyThread().run();
        System.out.println("main");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run");
    }
}