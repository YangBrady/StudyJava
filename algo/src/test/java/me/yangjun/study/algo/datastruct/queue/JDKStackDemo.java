package me.yangjun.study.algo.datastruct.queue;

import java.util.Deque;
import java.util.LinkedList;

public class JDKStackDemo {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
