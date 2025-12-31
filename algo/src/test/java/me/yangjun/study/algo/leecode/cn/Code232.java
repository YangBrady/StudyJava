package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/">LeeCode 232 </a>
 */
public class Code232 {
    @Test
    public void test1() {
        // MyQueue queue = new MyQueue();
        MyQueueV2 queue = new MyQueueV2();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
    }

    private static class MyQueue {
        Deque<Integer> stack;

        public MyQueue() {
            this.stack = new LinkedList<>();
        }

        public void push(int x) {
            Deque<Integer> temp = new LinkedList<>();
            while (!this.stack.isEmpty()) {
                temp.push(this.stack.pop());
            }
            temp.push(x);
            while (!temp.isEmpty()) {
                this.stack.push(temp.pop());
            }
        }

        public int pop() {
            if (this.stack.isEmpty()) {
                return -1;
            }
            return this.stack.pop();
        }

        public int peek() {
            if (this.stack.isEmpty()) {
                return -1;
            }
            return this.stack.peek();
        }

        public boolean empty() {
            return this.stack.isEmpty();
        }
    }

    // FIFO
    private static class MyQueueV2 {
        // FILO
        Stack<Integer> stack;
        Stack<Integer> tempStack;

        public MyQueueV2() {
            this.stack = new Stack<>();
            this.tempStack = new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
        }

        public int peek() {
            if (empty()) {
                throw new NullPointerException("");
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                tempStack.add(pop);
            }
            Integer result = tempStack.peek();

            while (!tempStack.isEmpty()) {
                Integer pop = tempStack.pop();
                stack.add(pop);
            }

            return result;
        }

        public int pop() {
            if (empty()) {
                throw new NullPointerException("");
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                tempStack.add(pop);
            }
            Integer result = tempStack.pop();

            while (!tempStack.isEmpty()) {
                Integer pop = tempStack.pop();
                stack.add(pop);
            }

            return result;
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
