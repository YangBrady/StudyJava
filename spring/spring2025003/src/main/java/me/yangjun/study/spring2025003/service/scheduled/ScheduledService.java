package me.yangjun.study.spring2025003.service.scheduled;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduledService {
    /**
     * 项目同时指定定时任务线程池和异步任务线程池的时候，最好Async指定一个线程池，不然会报冲突
     */
    @Async("asyncExecutor")
    @Scheduled(cron = "0/1 * * * * *")
    public void foo1() throws InterruptedException {
        log.info("foo1 start");
        TimeUnit.SECONDS.sleep(5);
        log.info("foo1 end");
    }

    @Async("asyncExecutor")
    @Scheduled(cron = "1/1 * * * * *")
    public void foo2() throws InterruptedException {
        log.info("foo2 start");
        TimeUnit.SECONDS.sleep(5);
        log.info("foo2 end");
    }

    @Async("asyncExecutor")
    @Scheduled(cron = "2/1 * * * * *")
    public void foo3() throws InterruptedException {
        log.info("foo3 start");
        TimeUnit.SECONDS.sleep(5);
        log.info("foo3 end");
    }
}
