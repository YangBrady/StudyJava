package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <a herf="https://leetcode.cn/problems/house-robber/">LeeCode 198</a>
 */
public class Code198 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,1})
                ,Arguments.of(new int[]{2,7,9,3,1})
                // ,Arguments.of(3)
                // ,Arguments.of(4)
                // ,Arguments.of(10)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int[] arr) {
        System.out.println(new Solution().foo(arr));
    }

    private static class Solution {
        public int foo(int[] arr) {
            if (arr.length == 1) {
                return arr[0];
            }
            // dp[i] ? i==arr.length-1

            // dp[0] = arr[0]
            // dp[1] = arr[0] || arr[1]
            // dp[2] = arr[1] || arr[0] + arr[2]
            // dp[3] = arr[1] + arr[3] || arr[0] + arr[2]

            // dp[i] = 0到i-1 || 0到i-2 + 最后一个
            // dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i])

            // init dp[i]
            int dp0 = arr[0];
            int dp1 = Math.max(arr[0], arr[1]);
            // for
            for (int i = 2; i < arr.length; i++) {
                int temp = Math.max(dp1, dp0 + arr[i]);
                dp0 = dp1;
                dp1 = temp;
            }
            return dp1;
            // ..
        }
    }
}
