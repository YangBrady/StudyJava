package me.yangjun.study.algo.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 你可以按 任何顺序 返回答案
 */
@Slf4j
public class CnDemo77 {
    public static void main(String[] args) {
        System.out.println(new CnDemo77().combine(4, 2));
    }

    private final LinkedList<Integer> path = new LinkedList<>();
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        path.clear();
        result.clear();
        backtracking(0, n, k);
        return result;
    }

    public void backtracking(int startIndex, int n, int deep) {
        // 终止条件
        if (path.size() == deep) {
            // 存放结果
            result.add(new LinkedList<>(path));
            return;
        }

        // 递归
        for (int i = startIndex; deep - path.size() <= n - i; i++) {
            path.add(i + 1);
            backtracking(i + 1, n, deep);
            path.removeLast();
        }
    }
}
