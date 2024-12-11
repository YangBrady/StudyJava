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
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/description/">LeeCode 131</a>
 */
public class Demo131 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("aab"),
                Arguments.of("a")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(String digits) {
        System.out.println(new Demo131.Solution().partition(digits));
    }

    private static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            List<String> path = new ArrayList<>();
            backtracking(0, s, path, result);
            return result;
        }

        private void backtracking(int startIndex, String str, List<String> path, List<List<String>> result) {
        }
    }
}