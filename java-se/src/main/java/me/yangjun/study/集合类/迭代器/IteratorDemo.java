package me.yangjun.study.集合类.迭代器;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mooejun
 * @since 2020/11/02 22:42
 */
@Slf4j
public class IteratorDemo {

	@Test
	public void test01() {

		// 正常情况
		// List<String> testArr = new ArrayList<>();
		// testArr.add("GTS");
		// testArr.add("BU");
		// testArr.add("SDT");

		// 数组转的List
		String[] flowArr = {"GTS", "BU", "SDT"};
		List<String> testArr = Arrays.asList(flowArr);

		// 优化方案
		// List<String> testArr = new ArrayList<>();
		// Collections.addAll(testArr, flowArr);

		log.debug("testArr={}", testArr);

		testArr.removeIf(s -> s.equalsIgnoreCase("sdt"));
		log.debug(testArr.toString());
	}

	@Test
	public void test02() {
		ArrayList<String> b = new ArrayList<>();
		b.add("abcd1");
		b.add("abcd2");
		b.add("abcd3");
		b.add("abcd4");
		b.add("abcd5");
		for (int i = 0; i < b.size(); i++) {
			if ((b.get(i)).startsWith("abcd")) {
				b.remove(i);
			}
		}
		System.out.println(b.size());
		System.out.println(b);
	}

	@Test
	public void test03() {
		List<String> testArr = new ArrayList<>();
		testArr.add("a");
		testArr.add("b");
		testArr.add("c");
		testArr.add("d");
		testArr.add("e");
		testArr.removeIf(s -> s.equalsIgnoreCase("b"));
		System.out.println(testArr);
	}
}
