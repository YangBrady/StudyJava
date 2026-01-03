package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">LeeCode 002 </a>
 */
public class Code002 {
    @Test
    public void test1() {
        // MyQueue queue = new MyQueue();
        Solution solution = new Solution();
        // ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        // ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 核心思路：跟加法运算一样，每次只计算当前位的值，进位的存下来下次计算，这样可以避免直接相加的时候溢出
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode virNode = new ListNode();
            ListNode temp = virNode;

            int remain = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 == null ? 0 : l1.val;
                int n2 = l2 == null ? 0 : l2.val;

                int sum = n1 + n2 + remain;

                int i = sum % 10;
                remain = sum / 10;

                temp.next = new ListNode(i);
                temp = temp.next;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            // 最终保留的进位值单独存一个
            if (remain > 0) {
                temp.next = new ListNode(remain);
            }
            return virNode.next;
        }
    }
}
