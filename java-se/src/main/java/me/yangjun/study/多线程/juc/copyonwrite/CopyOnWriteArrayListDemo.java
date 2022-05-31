package me.yangjun.study.多线程.juc.copyonwrite;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mooejun
 * @since 2022/5/30 18:04
 */
@Slf4j
public class CopyOnWriteArrayListDemo {
	// private static final List<String> list = new ArrayList<>();
	private static final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		list.add("1");
		list.add("2");
		list.add("3");

		// 存放10个线程的线程池
		ExecutorService service = Executors.newFixedThreadPool(5);

		// 并发读取数据
		for (int i = 0; i < 10; i++) {
			service.execute(() -> list.forEach(log::debug));
		}

		// 并发写入数据
		for (int i = 0; i < 10; i++) {
			service.execute(() -> list.add("121"));
		}

		log.debug(Arrays.toString(list.toArray()));
		TimeUnit.SECONDS.sleep(3);
		log.debug(Arrays.toString(list.toArray()));

		service.shutdown();
		log.debug("over");
	}
}
