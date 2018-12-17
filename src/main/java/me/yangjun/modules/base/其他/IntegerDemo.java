package me.yangjun.modules.base.其他;

import org.junit.Test;

public class IntegerDemo {

	@Test
	public void testOver() {
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int sum = a + b;
		System.out.println("a=" + a + ", sum=" + sum);
	}
}
