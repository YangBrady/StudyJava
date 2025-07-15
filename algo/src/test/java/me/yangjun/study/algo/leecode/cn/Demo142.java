package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/">LeeCode 142</a>
 */
public class Demo142 {
    static Stream<Arguments> dataProvider() {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(0);
        node.next.next = new ListNode(-4);
        node.next.next.next = node;

        return Stream.of(Arguments.of(head));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(ListNode head) {
        System.out.println(new Demo142.Solution().detectCycle(head));
    }

    private static class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            // 会和后快指针再次从头结点出发后相遇的时候，fast就是入口处
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
    }
}
