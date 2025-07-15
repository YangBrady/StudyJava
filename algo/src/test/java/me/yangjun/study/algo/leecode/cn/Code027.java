  package me.yangjun.study.algo.leecode.cn;

public class Code027 {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
//        int target = 3;
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;
        System.out.println(new Code027().removeElement(nums, target));
    }

    /**
     * 快慢指针
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (val == nums[fast]) {
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }
}
