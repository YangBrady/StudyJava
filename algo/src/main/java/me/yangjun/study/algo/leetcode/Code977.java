package me.yangjun.study.algo.leetcode;

import java.util.Arrays;

public class Code977 {

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(new Code977().sortedSquares(nums)));
    }

    /**
     * 原数组平方后，两边的数肯定会排在最右边一前一后
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int arrIndex = nums.length - 1;
        while (left <= right) {
            int leftNum = nums[left] * nums[left];
            int rightNum = nums[right] * nums[right];
            if (leftNum <= rightNum) {
                result[arrIndex] = rightNum;
                arrIndex--;
                right--;
            } else {
                result[arrIndex] = leftNum;
                arrIndex--;
                left++;
            }
        }
        return result;
    }
}
