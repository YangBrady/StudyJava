package me.yangjun.study.algo.leetcode;

import me.yangjun.study.algo.leetcode.linklist.ListNode;

public class Code141 {

    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//        ListNode node = new ListNode(2);
//        head.next = node;
//        node.next = new ListNode(0);
//        node.next.next = new ListNode(4);
//        node.next.next.next = node;

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new Code141().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null && fast.next != null) {
                fast = fast.next;
            } else {
                fast = null;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
