package me.yangjun.modules.base.多线程.demo001;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author mooejun
 * @since 2019/09/01
 */
public class MyProducer implements Runnable {

    private BlockingQueue<List<Student>> queue;

    public MyProducer(BlockingQueue<List<Student>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // 从数据库读取数据并插入到队列中
        List<Student> data = new ArrayList<>();
        data.add(new Student("哈哈", 20, new Date()));
        data.add(new Student("嘻嘻", 21, new Date()));
        data.add(new Student("嘿嘿", 22, new Date()));

        try {
            queue.put(data);
            Thread.sleep(5 * 1000);
            queue.put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
