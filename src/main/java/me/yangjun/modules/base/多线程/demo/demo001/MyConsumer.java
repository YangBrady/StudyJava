package me.yangjun.modules.base.多线程.demo.demo001;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author mooejun
 * @since 2019/09/01
 */
public class MyConsumer implements Runnable {

    private BlockingQueue<List<Student>> queue;

    public MyConsumer(BlockingQueue<List<Student>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Student> students = queue.poll(5, TimeUnit.SECONDS);
                for (Student student : students) {
                    System.out.println(Thread.currentThread().getName() + " --- " + student);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
