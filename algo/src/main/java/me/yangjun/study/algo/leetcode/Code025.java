package me.yangjun.study.algo.leetcode;

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
        ListNode virNode = new ListNode(0, head);
        ListNode pre = virNode;
        ListNode cur = head;
        int skip = 0;
        while (skip < k && cur != null) {
            ListNode rest = cur.next;
            cur.next = null;
            skip++;
            if (skip == k) {
                // 反转部分链表
                ListNode reverseNode = reverseList(pre);

                skip = 0;
            }
        }
        if (skip < k) {

        }
        ListNode restNode = fast.next;

        if (checkRest(restNode, k)) {
        }


        return virNode.next;
    }

    public ListNode reverseList(ListNode head) {
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

    public boolean checkRest(ListNode node, int k) {
        ListNode tmp = new ListNode(0, node);
        for (int i = 0; i < k + 1; i++) {
            if (tmp == null) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
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
