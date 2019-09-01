package me.yangjun.modules.base.多线程.同步;

import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁对象
 *
 * @author mooejun
 * @since 2019/06/29
 */
public class BankLock {
    // 锁对象
    private Lock bankLoack = new ReentrantLock();
    // 条件对象, 可以创建多个
    private Condition sufficientFunds;

    public BankLock() {
        this.sufficientFunds = bankLoack.newCondition();
    }

    /**
     * 不同步的方法
     *
     * @param fromAcc
     * @param toAcc
     * @param amount
     */
    public void transfer01(int fromAcc, int toAcc, int amount) {
        System.out.println("从账户" + fromAcc + "转出金额" + amount + "到" + toAcc);
    }

    /**
     * 同步的方法
     *
     * @param fromAcc
     * @param toAcc
     * @param amount
     */
    public void transfer02(int fromAcc, int toAcc, int amount) {
        bankLoack.lock();
        try {
            System.out.println("从账户" + fromAcc + "转出金额" + amount + "到" + toAcc);
        } finally {
            bankLoack.unlock();
        }
    }

    /**
     * 检查余额可能正常, 但是真正到了转账的时候可能被其他线程修改了余额导致金额不足
     *
     * @param fromAcc
     * @param toAcc
     * @param amount
     */
    public void transfer03_01(int fromAcc, int toAcc, int amount) {
        bankLoack.lock();
        try {
            if (this.getBalance(fromAcc) >= amount) {
                System.out.println("从账户" + fromAcc + "转出金额" + amount + "到" + toAcc);
            }
        } finally {
            bankLoack.unlock();
        }
    }

    /**
     * 条件对象
     *
     * @param fromAcc
     * @param toAcc
     * @param amount
     */
    public void transfer03_02(int fromAcc, int toAcc, int amount) throws InterruptedException {
        bankLoack.lock();
        try {
            while (this.getBalance(fromAcc) < amount) sufficientFunds.await(); // 进入等待集
            System.out.println("从账户" + fromAcc + "转出金额" + amount + "到" + toAcc);
            sufficientFunds.signalAll(); // 释放所有等待集中的线程
        } finally {
            bankLoack.unlock();
        }
    }

    public int getBalance(int fromAcc) {
        int balance = 100;
        bankLoack.lock();
        try {
            System.out.println("账户" + fromAcc + "余额" + balance);
        } finally {
            bankLoack.unlock();
        }
        return balance;
    }
}
