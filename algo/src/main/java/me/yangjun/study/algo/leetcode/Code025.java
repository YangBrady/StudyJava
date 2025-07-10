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
        ListNode dummyNode = new ListNode(0, head);
        ListNode first = dummyNode;
        ListNode cur = first;
        ListNode rest = first.next;
        while (true) {
            int skip = 0;
            for (int i = 0; i < k; i++) {
                skip++;
                if (cur.next != null) {
                    cur = cur.next;
                }
            }
            // 根据 k 划分 出子链表
            if (skip != k) {
                break;
            }
            // 记录剩余节点
            rest = cur.next;
            // 反转部分链表 0->1->2->3
            ListNode newFirst = reverseList(first.next, cur);

            // 前面一部分的尾节点 -> 反转子链的头结点
            first.next = newFirst;
            // 反转子链的尾节点 -> 剩余部分的头节点
            cur.next = rest;
        }
        return dummyNode.next;
    }

    public ListNode reverseList(ListNode headNode, ListNode endNode) {
        return reverse(null, headNode, endNode);
    }

    public ListNode reverse(ListNode first, ListNode end, ListNode endNode) {
        if (end == endNode) {
            return first;
        }
        ListNode temp = end.next;
        end.next = first;
        return reverse(end, temp, endNode);
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

        @Override
        public String toString() {
            ListNode temp = this;
            StringBuilder sb = new StringBuilder("[");
            while (temp != null) {
                sb.append(temp.val);
                if (temp.next != null) {
                    sb.append(" -> ");
                }
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
