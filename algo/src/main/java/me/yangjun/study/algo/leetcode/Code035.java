package me.yangjun.study.algo.leetcode;

public class Code035 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(new Code035().searchInsert1(nums, target));
        System.out.println(new Code035().searchInsert2(nums, target));
    }

    public int searchInsert1(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     */
    public int searchInsert2(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (right - left <= 1) {
                return right;
            }
        }

        return mid;
    }
}
