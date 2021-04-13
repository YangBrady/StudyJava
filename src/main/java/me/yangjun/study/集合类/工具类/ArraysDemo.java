package me.yangjun.study.集合类.工具类;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author mooejun
 * @since 2021/04/13 20:56
 */
public class ArraysDemo {

	@Test
	public void asListTest1() {
		int[] arr = {1, 2, 3};
		List<int[]> list = Arrays.asList(arr);
		System.out.println(list.size());
	}

	@Test
	public void asListTest2() {
		String[] arr = {"天", "地", "玄", "黄"};
		List<String> list = Arrays.asList(arr);
		arr[1] = "哈哈";
		list.set(2, "嘿嘿");
		System.out.println(Arrays.toString(arr));
		System.out.println(list.toString());
	}
}
