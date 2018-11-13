package me.yangjun.modules.base.异常;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * 异常链
 * 
 * @author yangjun
 */
public class ExceptionLinkDemo {

	@Test
	private static List<Integer> getInputData() {
		List<Integer> intList = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		try {
			int numberA = scanner.nextInt();
			int numberB = scanner.nextInt();
			intList.add(numberA);
			intList.add(numberB);
		} catch (InputMismatchException e) {
			throw e;
		} finally {
			scanner.close();
		}
		return intList;
	}

	private static int add() throws Exception {
		int result;
		try {
			List<Integer> numberList = getInputData();
			result = numberList.get(0) + numberList.get(1);
		} catch (InputMismatchException e) {
			// throw new Exception("add Error计算失败");
			throw new Exception("add Error计算失败", e);
		}

		return result;
	}

	public static void main(String[] args) {
		try {
			System.out.println(ExceptionLinkDemo.add());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
