package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/">LeeCode 150 </a>
 */
public class Code150 {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of((Object)new String[] {"2", "1", "+", "3", "*"}),
            Arguments.of((Object)new String[] {"4","13","5","/","+"}),
            Arguments.of((Object)new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"})
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(String[] param) {
        System.out.println(new Solution().evalRPN(param));
    }

    private static class Solution {

        public int evalRPN(String[] tokens) {
            Set<String> flagSet = new HashSet<>(4);
            flagSet.add("+");
            flagSet.add("-");
            flagSet.add("*");
            flagSet.add("/");

            Deque<String> deque = new LinkedList<>();
            for (String token : tokens) {
                if (flagSet.contains(token)) {
                    Integer p1 = Integer.valueOf(deque.pop());
                    Integer p2 = Integer.valueOf(deque.pop());
                    switch (token) {
                        case "+":
                            deque.push(String.valueOf(p2 + p1));
                            break;
                        case "-":
                            deque.push(String.valueOf(p2 - p1));
                            break;
                        case "*":
                            deque.push(String.valueOf(p2 * p1));
                            break;
                        case "/":
                            String s = String.valueOf(p2 / p1);
                            deque.push(s);
                            break;
                    }
                } else {
                    deque.push(token);
                }
            }
            if (deque.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(deque.peek());
        }
    }
}
