package me.yangjun.study.字符串;

import org.junit.jupiter.api.Test;

/**
 * @author mooejun
 * @since 2019/05/06
 */
public class StringTest {

	@Test
	public void demo001() {
		String a = "abcd.txt";
		String b = a.substring(0, a.lastIndexOf("."));
		System.out.println(b);

		System.out.println(a.indexOf("abcd"));

		System.out.println(a.substring(a.indexOf("abcd")));
	}
}
