package me.yangjun.study.algo.leetcode;

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

    public ListNode reverse(ListNode first, ListNode end) {
        if (end == null) {
            return first;
        }
        ListNode temp = end.next;
        end.next = first;
        return reverse(end, temp);
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
