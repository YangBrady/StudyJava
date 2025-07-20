package me.yangjun.study.algo.leecode.cn;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/description/">LeeCode 225 </a>
 */
public class Code225 {
    @Test
    public void test1() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.top();
        myStack.empty();
    }

    private static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            this.queue = new LinkedList<>();
        }

        public void push(int x) {
            Queue<Integer> tmp = new LinkedList<>();
            tmp.add(x);

            while(!this.queue.isEmpty()) {
                Integer poll = this.queue.poll();
                tmp.add(poll);
            }
            this.queue = tmp;
        }

        public int pop() {
            if (this.queue.isEmpty()) {
                return -1;
            }
            return this.queue.poll();
        }

        public int top() {
            if (this.queue.isEmpty()) {
                return -1;
            }
            return this.queue.peek();
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
