package me.yangjun.study.多线程.同步;

import java.util.concurrent.TimeUnit;

/**
 * @author mooejun
 * @since 2020/04/20
 */
public class VisibleDemo {
	private static boolean flag = true;

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(() -> {
			int i = 0;
			while (flag) {
				i++;
			}
		});
		thread.start();

		TimeUnit.SECONDS.sleep(1);
		flag = false;
	}
}
