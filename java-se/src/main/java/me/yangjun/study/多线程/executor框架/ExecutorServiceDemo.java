package me.yangjun.study.多线程.executor框架;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author mooejun
 * @since 2019/08/09
 */
@Slf4j
public class ExecutorServiceDemo {

	ExecutorService executorService = Executors.newFixedThreadPool(3);
	// ExecutorService executorService = Executors.newCachedThreadPool();
	// ExecutorService executorService = Executors.newSingleThreadExecutor();
	// ExecutorService executorService = Executors.newScheduledThreadPool(5);

	@Test
	public void exeRunnable() throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			executorService.execute(new TestRunnable(i+"线程"));
			// TimeUnit.MILLISECONDS.sleep(500);
			log.debug("********** call times:" + i + "**********");
		}
		executorService.shutdown();
	}

	@Test
	public void exeCallable() {
		for (int i = 1; i <= 5; i++) {
			executorService.execute(new TestRunnable(i+"线程"));
			log.debug("********** call times:" + i + "**********");
		}
		executorService.shutdown();
	}

	/**
	 * 主线程不结束的话线程池会继续跑完，主线程结束线程池也没了
	 * @throws InterruptedException
	 */
	@Test
	public void testShutdown() throws InterruptedException {
		for (int i = 1; i <= 3; i++) {
			executorService.execute(new TestRunnable(i+"线程"));
			log.debug("********** call times:" + i + "**********");
		}
		executorService.shutdown();
		TimeUnit.SECONDS.sleep(3);
	}

	@Test
	public void testInvokeAny() throws InterruptedException, ExecutionException {
		List<TestCallable> tasks = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			tasks.add(new TestCallable("第" + i + "个线程"));
		}

		log.debug(System.currentTimeMillis() + "开启线程池");
		String future = executorService.invokeAny(tasks);
		log.debug(System.currentTimeMillis() + "future结果: " + future);

		executorService.shutdown();
	}

	/**
	 * invokeAll方法，先用容器把所有线程装起来，然后一起执行
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void testInvokeAll() throws InterruptedException, ExecutionException {
		List<TestCallable> tasks = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			tasks.add(new TestCallable("第" + i + "个线程"));
		}

		log.debug(System.currentTimeMillis() + "开启线程池");
		List<Future<String>> futures = executorService.invokeAll(tasks);
		for (Future<String> future : futures) {
			log.debug("future结果: " + future.get());
		}

		log.debug(System.currentTimeMillis() + "关闭线程池");
		executorService.shutdown();
	}

	/**
	 * CompletionService 提交多个任务 获取的时候获取最先执行完的结果
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void testCompletionService() throws InterruptedException, ExecutionException {
		CompletionService<String> service = new ExecutorCompletionService<>(executorService);

		for (int i = 1; i <= 5; i++) {
			service.submit(new TestCallable("第" + i + "个线程"));
		}

		for (int i = 1; i <= 5; i++) {
			log.debug(System.currentTimeMillis() + "获取结果");
			Future<String> future = service.take();
			log.debug(System.currentTimeMillis() + "获取结果:" + future.get());
		}

		log.debug(System.currentTimeMillis() + "关闭线程池");
		executorService.shutdown();
	}

}

@Slf4j
@Data
class TestRunnable implements Runnable {
	@NonNull
	private String name;

	@Override
	public void run() {
		log.debug("执行开始");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("执行结束");
	}
}

@Slf4j
@Data
class TestCallable implements Callable<String> {
	@NonNull
	private String name;

	@Override
	public String call() throws Exception {
		log.debug("执行开始");
		TimeUnit.SECONDS.sleep(2);
		log.debug("执行结束");
		return System.currentTimeMillis() + name;
	}
}
