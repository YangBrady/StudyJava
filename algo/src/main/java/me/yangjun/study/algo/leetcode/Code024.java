package me.yangjun.study.algo.leetcode;

import me.yangjun.study.algo.leetcode.linklist.ListNode;

public class Code024 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(new Code024().swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode virNode = new ListNode(0, head);
        ListNode pre = virNode;
        while (pre.next != null && pre.next.next != null) {
            ListNode p = pre.next;
            ListNode q = p.next;

            pre.next = q;
            p.next = q.next;
            q.next = p;

            pre = pre.next.next;
        }
        return virNode.next;
    }
}
