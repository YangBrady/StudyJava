package me.yangjun.study.algo.leetcode;

public class Code206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(new Code206().reverseList(head));
    }

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

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
