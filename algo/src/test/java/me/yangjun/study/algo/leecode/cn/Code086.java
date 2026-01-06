package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/partition-list/description/">LeeCode 86</a>
 */
public class Code086 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                // Arguments.of(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3)
                // ,
            Arguments.of(new ListNode(2, new ListNode(1)), 2)
                // ,
                // Arguments.of("2")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(ListNode head, int x) {
        ListNode partition = new Solution().partition(head, x);
        System.out.println(partition);
    }

     // Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode less = new ListNode();
            ListNode lessIndex = less;

            ListNode more = new ListNode();
            ListNode moreEnd = more;

            // less more
            ListNode temp = head;
            while (temp != null) {
                if (temp.val < x) {
                    lessIndex.next = new ListNode(temp.val);
                    lessIndex = lessIndex.next;
                } else {
                    moreEnd.next = new ListNode(temp.val);
                    moreEnd = moreEnd.next;
                }
                temp = temp.next;
            }

            // combine
            if (more.next == null) {
                return less.next;
            } else if (less.next == null) {
                return more.next;
            }
            lessIndex.next = more.next;

            return less.next;
        }
    }
}
