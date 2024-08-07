package me.yangjun.study.输入输出.字符流;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {

	/**
	 * 读取单个字符
	 */
	@Test
	public void testRead() throws IOException {
		System.out.println("相对路径的地址 = " + System.getProperty("user.dir"));
		Reader reader = new FileReader("src/main/java/me/yangjun/modules/base/输入输出/字符流/ReaderDemoTest01.txt");
		int a = reader.read();
		System.out.println(a);
		reader.close();
	}

	/**
	 * 读取指定长度数据
	 */
	@Test
	public void testRead2() throws IOException {
		Reader reader = new FileReader("src/main/java/me/yangjun/modules/base/输入输出/字符流/ReaderDemoTest01.txt");
		char[] arr = new char[1024];// 读取n个字节并放入长度为n的数组中
		int a = reader.read(arr);// 返回读取到的字节数
		System.out.println(arr);
		System.out.println("a = " + a);
		reader.close();
	}

	/**
	 * 读取全部内容
	 */
	@Test
	public void testRead3() throws IOException {
		Reader reader = new FileReader("src/main/java/me/yangjun/modules/base/输入输出/字符流/ReaderDemoTest01.txt");
		char[] arr = new char[1024];
		int len = 0;
		while ((len = reader.read(arr)) != -1) {
			System.out.print(new String(arr, 0, len));// 不直接输出arr的原因是数组后面部分存有上一次读取的数据
		}
		reader.close();
	}
}
