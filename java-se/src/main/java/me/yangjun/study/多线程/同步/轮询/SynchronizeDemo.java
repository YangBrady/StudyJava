package me.yangjun.study.多线程.同步.轮询;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SynchronizeDemo {
    public static void main(String[] args) {
        DealObj dealObj = new DealObj();
        Thread t1 = new Thread(new DealThreadA(dealObj));
        t1.setName("增加线程---");
        t1.start();
        Thread t2 = new Thread(new DealThreadB(dealObj));
        t2.setName("停止线程---");
        t2.start();
    }

}

@Slf4j
@Data
class DealObj {
    // private volatile List<String> dealList = new ArrayList<>();
    private List<String> dealList = new ArrayList<>(); // 不用volatile可能会失效

    public void addData() {
        dealList.add("嘿嘿");
    }

    public int size() {
        return dealList.size();
    }
}


@Slf4j
@Data
@AllArgsConstructor
class DealThreadA implements Runnable {
    private DealObj dealObj;

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            dealObj.addData();
            try {
                log.info("数量+1，当前数量=" + dealObj.size());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

@Slf4j
@Data
@AllArgsConstructor
class DealThreadB implements Runnable {
    private DealObj dealObj;

    @Override
    public void run() {
        log.info("开始");
        try {
            while (true) {
                // log.info("数量==" + dealObj.size());
                if (dealObj.size() == 3) {
                    log.info("数量够了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
