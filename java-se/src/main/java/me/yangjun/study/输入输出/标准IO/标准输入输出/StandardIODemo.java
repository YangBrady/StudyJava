package me.yangjun.study.输入输出.标准IO.标准输入输出;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StandardIODemo {

	@Test
	public void testDemo() {
		System.out.println("please type:");
		int i;
		try {
			// throw new IOException();
			while ((i = System.in.read()) > -1) {
				System.out.println((char) i);
			}
		} catch (IOException e) {
			System.err.println("报错了");
			e.printStackTrace();
		}
	}
}
