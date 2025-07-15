package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;

public class Code206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        System.out.println(new Code206().reverseList(head));
        System.out.println(new Code206().reverseList2(head));
    }

    /**
     * 双指针法
     */
    public ListNode reverseList(ListNode head) {
        // 当前节点
        ListNode cur = head;
        // 前驱节点
        ListNode pre = null;
        while (cur != null) {
            // 当前节点.next 指向 pre
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归法
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode p, ListNode q) {
        // 终止条件，不存在后续节点了
        if (q == null) {
            return p;
        }
        ListNode temp = q.next;
        q.next = p;
        return reverse(q, temp);
    }
}
