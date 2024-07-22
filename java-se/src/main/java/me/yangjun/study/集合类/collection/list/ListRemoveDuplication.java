package me.yangjun.study.集合类.collection.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mooejun
 * @since 2020/11/16 22:23
 */
@Slf4j
public class ListRemoveDuplication {
	/**
	 * 使用两个for循环实现List去重(有序)
	 */
	public static List<Integer> removeDuplicationBy2For(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
				}
			}
		}
		return list;
	}

	/**
	 * 使用List集合contains方法循环遍历(有序)
	 */
	public static List<Integer> removeDuplicationByContains(List<Integer> list) {
		List<Integer> newList = new ArrayList<>();
		for (Integer integer : list) {
			boolean isContains = newList.contains(integer);
			if (!isContains) {
				newList.add(integer);
			}
		}
		list.clear();
		list.addAll(newList);
		return list;
	}

	/**
	 * 使用HashSet实现List去重(无序)
	 */
	public static List<Integer> removeDuplicationByHashSet(List<Integer> list) {
		HashSet<Integer> set = new HashSet<>(list);
		//把List集合所有元素清空
		list.clear();
		//把HashSet对象添加至List集合
		list.addAll(set);
		return list;
	}

	/**
	 * 使用TreeSet实现List去重(有序)
	 */
	public static List<Integer> removeDuplicationByTreeSet(List<Integer> list) {
		TreeSet<Integer> set = new TreeSet<>(list);
		//把List集合所有元素清空
		list.clear();
		//把HashSet对象添加至List集合
		list.addAll(set);
		return list;
	}

	/**
	 * 使用java8新特性stream实现List去重(有序)
	 */
	public static List<Integer> removeDuplicationByStream(List<Integer> list) {
		List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
		return newList;
	}


	@Test
	public void removeDuplication() {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		List<Integer> list5 = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 100000; i++) {
			int value = random.nextInt(500);
			list1.add(value);
			list2.add(value);
			list3.add(value);
			list4.add(value);
			list5.add(value);
		}
		long startTime;
		long endTime;

		startTime = System.currentTimeMillis();
		removeDuplicationBy2For(list4);
		endTime = System.currentTimeMillis();
		log.info("使用两个for循环实现List去重:" + (endTime - startTime) + "毫秒");

		startTime = System.currentTimeMillis();
		removeDuplicationByStream(list3);
		endTime = System.currentTimeMillis();
		log.info("使用java8新特性stream实现List去重:" + (endTime - startTime) + "毫秒");

		startTime = System.currentTimeMillis();
		removeDuplicationByContains(list5);
		endTime = System.currentTimeMillis();
		log.info("使用List集合contains方法循环遍历:" + (endTime - startTime) + "毫秒");

		startTime = System.currentTimeMillis();
		removeDuplicationByTreeSet(list2);
		endTime = System.currentTimeMillis();
		log.info("使用TreeSet实现List去重时间:" + (endTime - startTime) + "毫秒");

		startTime = System.currentTimeMillis();
		removeDuplicationByHashSet(list1);
		endTime = System.currentTimeMillis();
		log.info("使用HashSet实现List去重时间:" + (endTime - startTime) + "毫秒");

	}

}
