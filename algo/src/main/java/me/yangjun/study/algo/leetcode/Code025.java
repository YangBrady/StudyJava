package me.yangjun.study.algo.leetcode;

import me.yangjun.study.algo.leetcode.linklist.ListNode;

public class Code025 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);

//        System.out.println(new Code025().reverseList(head, head2));
        System.out.println(new Code025().reverseKGroup(head, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode p = dummyNode;
        ListNode q = p;
        ListNode rest = p.next;
        while (true) {
            int skip = 0;
            for (int i = 0; i < k; i++) {
                if (q.next != null) {
                    q = q.next;
                    skip++;
                }
            }
            // 根据 k 划分 出子链表
            if (skip != k) {
                break;
            }
            // 记录剩余节点
            rest = q.next;
            q.next = null;
            // 反转部分链表 1->2->3 --> 3->2->1
            ListNode newFirst = reverseList(p.next);

            // 反转以后，头是 newFirst 尾巴是 p.next
            // 反转子链的尾节点 -> 剩余部分的头节点
            ListNode newEnd = p.next;
            p.next = newFirst;
            // 前面一部分的尾节点 -> 反转子链的头结点
            newEnd.next = rest;

            p = newEnd;
            q = newEnd;
        }
        return dummyNode.next;
    }

    public ListNode reverseList(ListNode headNode) {
        return reverse(null, headNode);
    }

    public ListNode reverse(ListNode p, ListNode q) {
        if (q == null) {
            return p;
        }
        ListNode temp = q.next;
        q.next = p;
        return reverse(q, temp);
    }
}
