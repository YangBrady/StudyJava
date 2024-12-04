package me.yangjun.study.algo.leecode.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">LeeCode 216 </a>
 */
public class Demo216 {
    public static void main(String[] args) {
        // List<List<Integer>> result = new Solution().combinationSum3(3, 7);
        List<List<Integer>> result = new Solution().combinationSum3(3, 9);
        System.out.println(result);
    }

    static class Solution {
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
