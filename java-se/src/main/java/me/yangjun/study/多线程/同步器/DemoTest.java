package me.yangjun.study.多线程.同步器;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author mooejun
 * @since 2020/04/16
 */
public class DemoTest {

	@Test
	public void testCyclicBarrier() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
			System.out.println("开始运行");
		});

		for (int i = 1; i <= 3; i++) {
			new Thread(new TestRunnable("第" + i + "个线程", cyclicBarrier)).start();
		}
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class TestRunnable implements Runnable {

	private String name;
	private CyclicBarrier cyclicBarrier;

	@Override
	public void run() {
		try {
			System.out.println(getName() + "进入等待");
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + "进入结束运行");
	}
}