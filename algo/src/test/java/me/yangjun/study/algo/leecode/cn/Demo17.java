package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">LeeCode 17</a>
 */
public class Demo17 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                // Arguments.of("23")
                // ,
                Arguments.of("")
                // ,
                // Arguments.of("2")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(String digits) {
        System.out.println(new Demo17.Solution().letterCombinations(digits));
    }

    private static class Solution {
        private static final Map<Character, String> NUM2CHAR_MAP = new HashMap<>();

        static {
            NUM2CHAR_MAP.put('2', "abc");
            NUM2CHAR_MAP.put('3', "def");
            NUM2CHAR_MAP.put('4', "ghi");
            NUM2CHAR_MAP.put('5', "jkl");
            NUM2CHAR_MAP.put('6', "mno");
            NUM2CHAR_MAP.put('7', "pqrs");
            NUM2CHAR_MAP.put('8', "tuv");
            NUM2CHAR_MAP.put('9', "wxyz");
        }

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return new ArrayList<>();
            }
            List<String> result = new ArrayList<>();
            StringBuilder path = new StringBuilder();

            List<String> charsList = new ArrayList<>();
            for (char c : digits.toCharArray()) {
                charsList.add(NUM2CHAR_MAP.get(c));
            }

            backtracking(charsList, digits.length(), path, result);
            return result;
        }

        private void backtracking(List<String> charsList, int deep, StringBuilder path, List<String> result) {
            if (path.length() == deep) {
                result.add(path.toString());
                return;
            }
            String curNumChars = charsList.get(path.length());
            for (int i = 0; i < curNumChars.length(); i++) {
                path.append(curNumChars.charAt(i));
                backtracking(charsList, deep, path, result);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
