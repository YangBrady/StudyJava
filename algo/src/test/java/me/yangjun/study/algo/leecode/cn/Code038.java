package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <a https://leetcode.cn/problems/count-and-say/description/">LeeCode 38</a>
 */
public class Code038 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(1)
                ,Arguments.of(2)
                ,Arguments.of(3)
                ,Arguments.of(4)
                ,Arguments.of(10)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int n) {
        System.out.println(new Solution().countAndSay(n));
    }

    private static class Solution {
        public String countAndSay(int n) {
            // 题目终止条件
            if (n < 1 || n > 30) {
                return null;
            }

            return rev("", n);
        }

        public String rev(String temp, int n) {
            // 递归终止条件
            if (n == 1) {
                return "1";
            }

            // 核心任务，取出上一步的数据，然后解析
            temp = rev(temp, n - 1);
            // parse
            return parse(temp);
        }

        public String parse(String temp) {
            int i = 0, j = 1;
            StringBuilder sb = new StringBuilder();
            while (j < temp.length()) {
                if (temp.charAt(i) != temp.charAt(j)) {
                    // comp same part
                    sb.append(j - i).append(temp.charAt(i));
                    i = j;
                }
                j++;
            }
            // comp rest part
            sb.append(j - i).append(temp.charAt(i));
            return sb.toString();
        }
    }
}
