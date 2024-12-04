package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">LeeCode 216 </a>
 */
public class Demo216 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(3, 7),
                Arguments.of(3, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int k, int n) {
        System.out.println(new Demo216.Solution().combinationSum3(k, n));
    }

    private static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            LinkedList<Integer> path = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            backtracking(0, k, n, n, path, result);
            return result;
        }

        /**
         * 回溯
         *
         * @param startIndex 开始节点
         * @param curPath    当前遍历的路径
         * @param result     结果集
         */
        private void backtracking(int startIndex, int k, int n, int sum, LinkedList<Integer> curPath, List<List<Integer>> result) {
            // 终止条件
            if (curPath.size() == k && sum == 0) {
                result.add(new ArrayList<>(curPath));
                return;
            }
            // 递归，剪枝
            for (int i = startIndex; i < 9 && curPath.size() < k; i++) {
                if (sum < 0) {
                    continue;
                }
                curPath.push(i + 1);
                backtracking(i + 1, k, n, sum-i-1, curPath, result);
                curPath.pop();
            }
        }
    }
}
