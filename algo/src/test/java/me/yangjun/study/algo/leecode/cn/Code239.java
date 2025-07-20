package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/">LeeCode 239 </a>
 */
public class Code239 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of(new int[] {1,3,1,2,0,5}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int[] nums, int k) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, k)));
    }

    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int resultSize = nums.length - k + 1;
            int[] result = new int[resultSize];

            Queue<Integer> queue = new LinkedList<>();
            int maxValue = Integer.MIN_VALUE;
            int lastMax = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                if (maxValue > nums[i]) {
                    lastMax = nums[i];
                } else {
                    lastMax = maxValue;
                    maxValue = nums[i];
                }
                queue.add(nums[i]);
            }
            result[0] = maxValue;

            for (int i = k; i < nums.length; i++) {
                Integer poll = queue.poll();
                queue.add(nums[i]);
                int maxValueInQueue;
                if (poll < result[i - k]) {
                    if (result[i - k] > nums[i]) {
                        maxValueInQueue = result[i - k];
                        lastMax = Math.max(lastMax, nums[i]);
                    } else {
                        maxValueInQueue = nums[i];
                    }
                } else {
                    if (lastMax > nums[i]) {
                        lastMax = nums[i];
                        maxValueInQueue = lastMax;
                    } else {
                        maxValueInQueue = nums[i];
                    }
                }
                result[i - k + 1] = maxValueInQueue;
            }

            return result;
        }

        public int findMaxValueInQueue(Queue<Integer> queue) {
            Queue<Integer> temp = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                temp.add(poll);
                max = Math.max(max, poll);
            }
            while (!temp.isEmpty()) {
                queue.add(temp.poll());
            }
            return max;
        }
    }
}
