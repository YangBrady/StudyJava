package me.yangjun.study.多线程.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author mooejun
 * @since 2020/04/15
 */
public class DemoTest {
	public static void main(String[] args) {
		FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

		System.out.println("开启线程");
		new Thread(futureTask).start();

		try {
			System.out.println("等待参数返回");
			System.out.println("参数返回" + futureTask.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}

class MyCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(3 * 1000);
		return "hi";
	}
}
