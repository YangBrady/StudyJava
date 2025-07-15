package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;

public class Code019 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

//        System.out.println(new Code019().removeNthFromEnd(head, 2));
//        System.out.println(new Code019().removeNthFromEnd2(head, 1));
        System.out.println(new Code019().removeNthFromEnd3(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeLength = 1;
        ListNode indexNode = head;
        while (indexNode.next != null) {
            nodeLength++;
            indexNode = indexNode.next;
        }
        // 剪切1
        if (nodeLength == n) {
            return head.next;
        }

        int cutIndex = nodeLength - n + 1;
        ListNode frontNode = head;
        ListNode nextNode = frontNode.next;
        ListNode next2Node = null;
        if (nextNode != null) {
            next2Node = nextNode.next;
        }

        // 剪切2以后的
        for (int i = 2; i < cutIndex; i++) {
            frontNode = frontNode.next;
            nextNode = frontNode.next;
            if (nextNode != null) {
                next2Node = nextNode.next;
            }
        }
        frontNode.next = null;
        if (next2Node != null) {
            frontNode.next = next2Node;
        }
        return head;
    }

    /**
     * 使用虚拟头结点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int nodeLength = 1;
        ListNode indexNode = head;
        while (indexNode.next != null) {
            nodeLength++;
            indexNode = indexNode.next;
        }
        // 构建一个虚拟的初始节点
        ListNode virNode = new ListNode(0, head);
        ListNode tmpNode = virNode;
        for (int i = 1; i < nodeLength - n + 1; i++) {
            tmpNode = tmpNode.next;
        }
        tmpNode.next = tmpNode.next.next;
        return virNode.next;
    }

    /**
     * 使用虚拟头结点 + 快慢指针
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        // 构建一个虚拟的初始节点
        ListNode virNode = new ListNode(0, head);
        ListNode slowNode = virNode;
        ListNode fastNode = virNode;
        // 快指针多走n + 1步，保证slow是要移除节点的上一个节点
        for (int i = 0; i <= n; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        if (slowNode.next != null) {
            slowNode.next = slowNode.next.next;
        }
        // 返回虚拟节点的下个节点是为了保证n=1的情况
        return virNode.next;
    }
}
