package me.yangjun.study.algo.datastruct.queue;

import java.util.LinkedList;
import java.util.Queue;

public class JDKQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        System.out.println(queue.peek());
    }
}
