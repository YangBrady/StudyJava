package me.yangjun.study.algo.leecode.cn;

import me.yangjun.study.algo.leecode.cn.entity.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 *
 * <a href="https://leetcode.cn/problems/valid-parentheses/description/">LeeCode 20 </a>
 */
public class Code020 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of("()"),
            Arguments.of("()[]{}"),
            Arguments.of("(}")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(String param) {
        System.out.println(new Solution().isValid(param));
    }

    private static class Solution {
        public boolean isValid(String s) {
            Deque<Character> deque = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (isPair(deque.peek(), c)) {
                    deque.pop();
                } else {
                    deque.push(c);
                }
            }
            return deque.isEmpty();
        }

        public boolean isPair(Character a, Character b) {
            if (a == null) {
                return false;
            }
            if (a.equals('(') && b.equals(')')) {
                return true;
            }
            if (a.equals('[') && b.equals(']')) {
                return true;
            }
            return a.equals('{') && b.equals('}');
        }
    }
}
