package me.yangjun.modules.base.多线程;

import org.junit.Test;

import me.yangjun.modules.base.多线程.创建.MyThread;

public class CreateThreadDemo {

	@Test
	public void doMyThread() {
		MyThread myThread = new MyThread();
		myThread.setName("自增线程");
		myThread.start();
	}
}
