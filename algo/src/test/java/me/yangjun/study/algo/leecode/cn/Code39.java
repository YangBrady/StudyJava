package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/description/">LeeCode 39</a>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Code39 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 6, 7}, 7),
                Arguments.of(new int[]{8, 7, 4, 3}, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int[] candidates, int target) {
        System.out.println(new Solution().combinationSum(candidates, target));
    }

    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();

            Arrays.sort(candidates);
            backtracking(0, candidates, target, path, result);
            return new ArrayList<>(result);
        }

        private void backtracking(int startIndex, int[] candidates, int target, LinkedList<Integer> path, List<List<Integer>> result) {
            int currentSum = path.stream().reduce(Integer::sum).orElse(0);
            // 累计满足条件则终止
            if (currentSum == target) {
                ArrayList<Integer> temp = new ArrayList<>(path);
                temp.sort(Integer::compareTo);
                result.add(temp);
                return;
            }
            // 超出则终止
            if (currentSum > target) {
                return;
            }
            // 递归
            for (int i = startIndex; i < candidates.length; i++) {
                // 剪枝，后面元素肯定更大
                if (currentSum + candidates[i] > target) {
                    continue;
                }
                path.add(candidates[i]);
                // 注意这里传入i，避免出现重复数据
                backtracking(i, candidates, target, path, result);
                path.removeLast();
            }
        }
    }
}
