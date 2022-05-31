package me.yangjun.study.utils;

import java.util.Random;

/**
 * @author mooejun
 * @since 2022/5/31 15:22
 */
public class DataUtils {
	public static int[] genRandomIntArr(int size) {
		Random random = new Random();
		int[] intArr = new int[size];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = random.nextInt(1000);
		}
		return intArr;
	}
}
