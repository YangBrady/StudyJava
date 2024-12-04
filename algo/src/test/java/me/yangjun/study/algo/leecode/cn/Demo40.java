package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">LeeCode 40</a>
 */
public class Demo40 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 6, 7}, 7),
                Arguments.of(new int[]{8, 7, 4, 3}, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int[] candidates, int target) {
        System.out.println(new Demo40.Solution().combinationSum2(candidates, target));
    }

    private static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Set<List<Integer>> result = new HashSet<>();
            LinkedList<Integer> path = new LinkedList<>();

            Arrays.sort(candidates);
            backtracking(0, candidates, target, path, result);
            return new ArrayList<>(result);
        }

        private void backtracking(int startIndex, int[] candidates, int restSum, LinkedList<Integer> path, Set<List<Integer>> result) {
            // 累计满足条件则终止
            if (restSum == 0) {
                ArrayList<Integer> temp = new ArrayList<>(path);
                // temp.sort(Integer::compareTo);
                result.add(temp);
                return;
            }
            // 超出则终止
            if (restSum < 0) {
                return;
            }
            // 递归
            for (int i = startIndex; i < candidates.length; i++) {
                // 大剪枝，后面元素肯定更大
                if (restSum - candidates[i] < 0) {
                    continue;
                }
                // 小剪枝，同层级相同元素子集一样，没必要再查
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                // 注意这里传入i，避免出现重复数据
                backtracking(i + 1, candidates, restSum - candidates[i], path, result);
                path.removeLast();
            }
        }
    }
}
