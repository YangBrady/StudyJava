package me.yangjun.modules.base.多线程.demo001;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author mooejun
 * @since 2019/09/01
 */
public class MyTest {
    public static void main(String[] args) {

        // 创建一个阻塞队列
        BlockingQueue<List<Student>> queue = new LinkedBlockingQueue<>();

        // 创建n个生产者线程
        MyProducer myProducer = new MyProducer(queue);

        // 创建n个消费者线程
        MyConsumer aMyConsumer = new MyConsumer(queue);
        MyConsumer bMyConsumer = new MyConsumer(queue);
        MyConsumer cMyConsumer = new MyConsumer(queue);

        // 创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(myProducer);

        executorService.submit(aMyConsumer);
        executorService.submit(bMyConsumer);
        executorService.submit(cMyConsumer);

        executorService.shutdown();
    }
}
