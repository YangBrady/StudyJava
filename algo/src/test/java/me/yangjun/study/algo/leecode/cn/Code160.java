package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/">LeeCode 160</a>
 */
public class Code160 {
    static Stream<Arguments> dataProvider() {
        ListNode headA = new ListNode(11);
        headA.next = new ListNode(12);

        ListNode headB = new ListNode(21);
        headB.next = new ListNode(22);
        headB.next.next = new ListNode(3);

        ListNode headC = new ListNode(31);
        headC.next = new ListNode(32);
        headC.next.next = new ListNode(33);

        headA.next.next = headC;
        headB.next.next.next = headC;

        return Stream.of(Arguments.of(headA, headB));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void foo1(ListNode headA, ListNode headB) {
        System.out.println(new Code160.Solution().getIntersectionNode1(headA, headB));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void foo2(ListNode headA, ListNode headB) {
        System.out.println(new Code160.Solution().getIntersectionNode2(headA, headB));
    }

    private static class Solution {
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            ListNode tempA = new ListNode(0, headA);
            while (tempA.next != null) {
                tempA = tempA.next;

                ListNode tempB = new ListNode(0, headB);
                while (tempB.next != null) {
                    tempB = tempB.next;
                    if (tempA == tempB) {
                        return tempA;
                    }
                }
            }
            return null;
        }

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            ListNode tempA = new ListNode(0, headA);
            Set<ListNode> setA = new HashSet<>();
            while (tempA.next != null) {
                tempA = tempA.next;
                setA.add(tempA);
            }
            ListNode tempB = new ListNode(0, headB);
            while (tempB.next != null) {
                tempB = tempB.next;
                if (setA.contains(tempB)) {
                    return tempB;
                }
            }
            return null;
        }

        public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
            // A + C + B = B + C + A
            // 也就是说pA走完后指向B，pB走完指向A，然后他们相等的时候就是相交点
            ListNode pA = new ListNode(0, headA);
            ListNode pB = new ListNode(0, headB);
            while (pA != pB) {
                pA = pA != null ? pA.next : headB;
                pB = pB != null ? pB.next : headA;
            }
            return pA;
        }
    }
}
