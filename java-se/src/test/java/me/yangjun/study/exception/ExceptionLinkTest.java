package me.yangjun.study.exception;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 异常链
 *
 * @author yangjun
 */
public class ExceptionLinkTest {
    public static List<Integer> getInputData() {
        List<Integer> intList = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int numberA = scanner.nextInt();
            int numberB = scanner.nextInt();
            intList.add(numberA);
            intList.add(numberB);
        } catch (InputMismatchException e) {
            throw e;
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
            System.out.println(ExceptionLinkTest.add());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
