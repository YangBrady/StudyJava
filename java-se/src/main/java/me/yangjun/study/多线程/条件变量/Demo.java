package me.yangjun.study.多线程.条件变量;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mooejun
 * @since 2020/04/14
 */
public class Demo {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	static int amount = 100;

	public void testMethod(String name) {
		System.out.println(name + "线程开始");
		lock.lock();
		try {
			while (amount < 200) {
				System.out.println(name + "线程await");
				condition.await();
			}
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		System.out.println(name + "线程结束");
	}

	public static void main(String[] args) throws InterruptedException {

		Demo demo = new Demo();

		new Thread(() -> {
			demo.testMethod("A");
		}).start();

		Thread.currentThread().sleep(3 * 1000);

		new Thread(() -> {
			Demo.amount = 300;
			demo.testMethod("B");
		}).start();

	}
}
