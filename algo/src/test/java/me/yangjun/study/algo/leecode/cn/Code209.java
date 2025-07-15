package me.yangjun.study.algo.leecode.cn;

public class Code209 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;

//        System.out.println(new Code209().minSubArrayLen(target, nums));
        System.out.println(new Code209().minSubArrayLen2(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
            int total = nums[i];
            int size = 1;
            for (int j = i + 1; j < nums.length; j++) {
                total += nums[j];
                size++;
                if (total >= target && (result >= size || result == 0)) {
                    result = size;
                }
            }
        }
        return result;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int total = 0;
        int result = Integer.MAX_VALUE;
        // 累计值小于目标值则 right 左移
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            // 累计值大于目标值则 left 右移
            while (total >= target) {
                result = Math.min(result, right - left + 1);
                total -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
