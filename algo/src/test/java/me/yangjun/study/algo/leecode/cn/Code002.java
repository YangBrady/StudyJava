package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 计算每个链表的值
            BigDecimal sum1 = getNums(l1);
            BigDecimal sum2 = getNums(l2);
            BigDecimal sum = sum1.add(sum2);

            // 拼接结果 123 -> 3-2-1
            String sumStr = sum.toPlainString();
            ListNode result = new ListNode(sum.remainder(BigDecimal.TEN).intValue());
            sum = sum.divide(BigDecimal.TEN);
            ListNode temp = result;
            for (int i = sumStr.length() - 2; i >= 0; i--) {
                BigDecimal i1 = sum.remainder(BigDecimal.TEN);
                sum = sum.divide(BigDecimal.TEN);
                temp.next = new ListNode(i1.intValue());
                temp = temp.next;
            }
            return result;
        }

        public BigDecimal getNums(ListNode listNode) {
            List<Integer> nodes = new ArrayList<>();
            ListNode temp = listNode;
            do {
                nodes.add(temp.val);
                temp = temp.next;
            } while (temp != null);

            BigDecimal sum = BigDecimal.ZERO;
            BigDecimal index = BigDecimal.ONE;
            for (int i = 0; i < nodes.size(); i++) {
                sum = sum.add(index.multiply(new BigDecimal(nodes.get(i))));
                index = index.multiply(BigDecimal.TEN);
            }
            return sum;
        }
    }
}
