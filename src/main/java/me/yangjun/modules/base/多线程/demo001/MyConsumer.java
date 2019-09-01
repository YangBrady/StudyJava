package me.yangjun.modules.base.多线程.demo001;

import java.util.List;
import java.util.concurrent.BlockingQueue;

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
        try {
            List<Student> students = queue.take();
            for (Student student : students) {
                System.out.println(Thread.currentThread().getName() + " --- " + student);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
