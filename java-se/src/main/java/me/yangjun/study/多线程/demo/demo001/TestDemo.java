package me.yangjun.study.多线程.demo.demo001;

import org.junit.Test;

public class TestDemo {

	@Test
	public void test00() {
		System.out.println("主线程开始执行");
		Thread t1 = new Thread(() -> {
			System.out.println("子线程开始执行");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("子线程wait时候被中断");
				System.out.println(e.getMessage());
			}
			System.out.println("子线程结束执行");
		});
		t1.start();
		System.out.println("主线程结束执行");
	}

	@Test
	public void test01() {
		Thread t1 = new Thread(() -> {
			System.out.println("开始执行");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
                System.out.println("阻塞时候被中断");
                System.out.println(e.getMessage());
			}
			System.out.println("结束执行");
		});
		t1.start();
		t1.interrupt();
	}

	@Test
	public void test02() {
		Thread t1 = new Thread(() -> {
			System.out.println("开始执行");
			try {
				Thread.currentThread().wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
                System.out.println("wait时候被中断");
                System.out.println(e.getMessage());
			}
			System.out.println("结束执行");
		});
		t1.start();
		t1.interrupt();
	}
}
