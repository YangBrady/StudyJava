package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/combinations/description/">LeeCode 77 </a>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Demo77 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(4, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int n, int k) {
        System.out.println(new Demo77.Solution().combine(n, k));
    }

    private static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> path = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            backtracking(0, n, k, path, result);
            return result;
        }

        /**
         * 回溯
         *
         * @param startIndex 开始节点
         * @param n          树的宽度
         * @param k          树的深度
         * @param path       当前遍历的路径
         * @param result     结果集
         */
        private void backtracking(int startIndex, int n, int k, LinkedList<Integer> path, List<List<Integer>> result) {
            // 终止条件
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            // 递归，剪枝
            for (int i = startIndex; k - path.size() <= n - i; i++) {
                path.add(i + 1);
                backtracking(i + 1, n, k, path, result);
                path.removeLast();
            }
        }
    }
}
