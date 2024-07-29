package me.yangjun.study.algo.data.struct.queue;

import java.util.Scanner;

public class QueueDemo {
    public static void main(String[] args) {
        BradyArrayQueue bradyArrayQueue = new BradyArrayQueue(5);
        while (true) {
            System.out.println("输入操作");
            System.out.println("【s】展示队列");
            System.out.println("【a】添加到队列");
            System.out.println("【g】从队列中获取");
            System.out.println("【h】获取队首元素");
            System.out.println("【e】退出");

            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "s":
                    bradyArrayQueue.showQueue();
                    break;
                case "a":
                    System.out.println("输入一个数字");
                    Scanner scannerTmp = new Scanner(System.in);
                    bradyArrayQueue.add(scannerTmp.nextInt());
                    break;
                case "g":
                    System.out.println(bradyArrayQueue.get());
                    break;
                case "h":
                    System.out.println(bradyArrayQueue.head());
                    break;
                case "e":
                    return;
            }
        }
    }
}
