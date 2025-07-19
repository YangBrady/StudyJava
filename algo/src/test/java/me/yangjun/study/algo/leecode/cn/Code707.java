package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/design-linked-list/description/">LeeCode 707 </a>
 */
public class Code707 {
    @Test
    public void test1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
        System.out.println(myLinkedList.head);
    }

    private static class MyLinkedList {
        ListNode head;
        int size;

        public MyLinkedList() {
            this.size = 0;
            this.head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index > size) {
                return -1;
            }

            int i = 0;
            ListNode tmp = this.head;
            while (i <= index) {
                if (tmp.next == null) {
                    return -1;
                }
                tmp = tmp.next;
                i++;
            }
            return tmp.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size || index < 0) {
                return;
            }

            ListNode addNode = new ListNode(val);

            int i = 0;
            ListNode pre = this.head;
            while (i <= index) {
                if (pre == null) {
                    return;
                }
                if (i == index) {
                    ListNode tmp = pre.next;
                    pre.next = addNode;
                    addNode.next = tmp;
                }
                pre = pre.next;
                i++;
            }

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index > size || index < 0) {
                return;
            }

            ListNode pre = this.head;
            int i = 0;
            while (i <= index) {
                if (pre == null) {
                    return;
                }
                if (i == index) {
                    ListNode cutNode = pre.next;
                    if (cutNode == null) {
                        return;
                    }
                    pre.next = cutNode.next;
                }
                pre = pre.next;
                i++;
            }
            size--;
        }
    }
}
