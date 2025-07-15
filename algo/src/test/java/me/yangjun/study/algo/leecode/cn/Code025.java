package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;

public class Code025 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new Code025().reverseKGroup(head, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode p = dummyNode;
        ListNode q = p;
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
            ListNode rest = q.next;

            // 反转以后的子链表，头是 partPre 尾巴是 p.next
            q.next = null;
            ListNode partPre = reverseList(p.next);
            ListNode partEnd = p.next;

            // 头指针指向子链的头节点
            p.next = partPre;
            // 子链表的尾巴指向剩余节点
            partEnd.next = rest;

            p = partEnd;
            q = partEnd;
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
