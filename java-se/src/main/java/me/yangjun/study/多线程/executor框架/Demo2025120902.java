package me.yangjun.study.多线程.executor框架;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class Demo2025120902 {

    public static void main(String[] args) {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();

        System.out.println("堆内存初始化大小: " + heapUsage.getInit() / 1024 / 1024 + " MB");
        System.out.println("堆内存已提交大小: " + heapUsage.getCommitted() / 1024 / 1024 + " MB");
        System.out.println("堆内存实际已使用: " + heapUsage.getUsed() / 1024 / 1024 + " MB");
        System.out.println("堆内存最大上限: " + heapUsage.getMax() / 1024 / 1024 + " MB"); // 这里应该接近5MB
    }
}
