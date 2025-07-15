package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/design-linked-list/description/">LeeCode 707 </a>
 */
public class Code707 {
//    @Test
//    public void test1() {
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        System.out.println(myLinkedList);
//        myLinkedList.addAtTail(3);
//        System.out.println(myLinkedList);
//    }
//
//    private static class MyLinkedList {
//        ListNode head;
//        int size;
//
//        public MyLinkedList() {
//            this.size = 0;
//        }
//
//        public int get(int index) {
//            int i = 0;
//            MyLinkedList tmp = this;
//            while (i <= index) {
//                if (this.next == null) {
//                    return -1;
//                }
//                tmp = this.next;
//                i++;
//            }
//            return tmp.val;
//        }
//
//        public void addAtHead(int val) {
//            addAtIndex(0, val);
//        }
//
//        public void addAtTail(int val) {
//            addAtIndex(size, val);
//        }
//
//        public void addAtIndex(int index, int val) {
//            if (index > size || index < 0) {
//                return;
//            }
//
//            size++;
//
//            ListNode dummy = new ListNode(0, head);
//            ListNode addNode = new ListNode(val);
//            ListNode temp = dummy;
//            int i = 0;
//            while (pre != null && i <= index) {
//                ListNode nextNode = pre.next;
//                ListNode rest = nextNode.next;
//
//                i++;
//                pre = pre.next;
//            }
//        }
//
//        public void deleteAtIndex(int index) {
//            MyLinkedList pre = this;
//            MyLinkedList q = this;
//            int i = 0;
//            while (i <= index && q != null) {
//                if (i == index) {
//                    pre.next = q.next;
//                } else {
//                    pre = q;
//                    q = q.next;
//                    i++;
//                }
//            }
//        }
//    }
}
