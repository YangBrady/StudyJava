package me.yangjun.study.多线程.executor框架;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author mooejun
 * @since 2019/08/09
 */
public class ExecutorServiceDemo {

	ExecutorService executorService = Executors.newFixedThreadPool(2);
	// ExecutorService executorService = Executors.newCachedThreadPool();
	// ExecutorService executorService = Executors.newSingleThreadExecutor();
	// ExecutorService executorService = Executors.newScheduledThreadPool(5);

	@Test
	public void exeRunable() {
		for (int i = 1; i <= 5; i++) {
			executorService.execute(new TestRunable());
			System.out.println("********** call times:" + i + "**********");
		}
		executorService.shutdown();
	}

	@Test
	public void exeCallable() {
		for (int i = 1; i <= 5; i++) {
			executorService.execute(new TestRunable());
			System.out.println("********** call times:" + i + "**********");
		}
		executorService.shutdown();
	}

	@Test
	public void testInvokeAny() throws InterruptedException, ExecutionException {
		List<TestCallable> tasks = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			tasks.add(new TestCallable("第" + i + "个线程"));
		}

		System.out.println(System.currentTimeMillis() + "开启线程池");
		String future = executorService.invokeAny(tasks);
		System.out.println(System.currentTimeMillis() + "future结果: " + future);

		executorService.shutdown();
	}

	@Test
	public void testInvokeAll() throws InterruptedException, ExecutionException {
		List<TestCallable> tasks = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			tasks.add(new TestCallable("第" + i + "个线程"));
		}

		System.out.println(System.currentTimeMillis() + "开启线程池");
		List<Future<String>> futures = executorService.invokeAll(tasks);
		for (Future<String> future : futures) {
			System.out.println("future结果: " + future.get());
		}

		System.out.println(System.currentTimeMillis() + "关闭线程池");
		executorService.shutdown();
	}

	@Test
	public void testCompletionService() throws InterruptedException, ExecutionException {
		CompletionService<String> service = new ExecutorCompletionService<>(executorService);

		List<TestCallable> tasks = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			service.submit(new TestCallable("第" + i + "个线程"));
		}

		for (int i = 1; i <= 5; i++) {
            System.out.println(System.currentTimeMillis() + "获取结果");
            Future<String> future = service.take();
            System.out.println(System.currentTimeMillis() + "获取结果:" + future.get());
		}

		System.out.println(System.currentTimeMillis() + "关闭线程池");
		executorService.shutdown();
	}

}

class TestRunable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "执行被调用了");
	}
}

class TestCallable implements Callable<String> {

	private String name;

	public TestCallable() {
	}

	public TestCallable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(3 * 1000);
		return System.currentTimeMillis() + name;
	}
}
