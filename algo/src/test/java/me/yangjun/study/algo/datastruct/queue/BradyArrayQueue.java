package me.yangjun.study.algo.datastruct.queue;

public class BradyArrayQueue {
    private final int maxSize;
    private final int[] array;

    private int rear = -1;
    private int front = -1;

    public BradyArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d={%d}\t", i, array[i]);
        }
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~");
            return;
        }
        printArray(this.array);
    }

    public void add(int value) {
        if (isFull()) {
            System.out.println("队列已满~");
            return;
        }
        rear++;
        array[rear] = value;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~");
        }
        front++;
        return array[front];
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~");
        }
        return array[front + 1];
    }
}
