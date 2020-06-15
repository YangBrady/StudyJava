package me.yangjun.study.多线程;

import me.yangjun.study.多线程.创建.MyThread;
import org.junit.Test;

public class CreateThreadDemo {

	@Test
	public void doMyThread() {
		MyThread myThread = new MyThread();
		myThread.setName("自增线程");
		myThread.start();
	}
}
