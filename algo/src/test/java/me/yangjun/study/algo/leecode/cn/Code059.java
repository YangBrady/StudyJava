package me.yangjun.study.algo.leecode.cn;

import java.util.Arrays;

public class Code059 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Code059().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 定义边界
        int lSide = 0;
        int rSide = n-1;
        int uSide = 0;
        int dSide = n-1;

        int val = 1;
        while (val <= n*n) {
            // 向右走
            for (int i = lSide; i <= rSide; i++) {
                result[uSide][i] = val;
                val++;
            }
            uSide++;

            // 向下走
            for (int i = uSide; i <= dSide; i++) {
                result[i][rSide] = val;
                val++;
            }
            rSide--;

            // 向左走
            for (int i = rSide; i >= lSide; i--) {
                result[dSide][i] = val;
                val++;
            }
            dSide--;

            // 向上走
            for (int i = dSide; i >= uSide; i--) {
                result[i][lSide] = val;
                val++;
            }
            lSide++;
        }
        return result;
    }
}
