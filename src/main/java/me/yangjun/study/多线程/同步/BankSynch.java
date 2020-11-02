package me.yangjun.study.多线程.同步;

/**
 * synchronized
 *
 * @author mooejun
 * @since 2019/06/29
 */
public class BankSynch {

    public synchronized void transfer(int fromAcc, int toAcc, int amount) throws InterruptedException {

        while (this.getBalance(fromAcc) < amount) this.wait(); // 进入等待集
        System.out.println("从账户" + fromAcc + "转出金额" + amount + "到" + toAcc);
        this.notifyAll(); // 释放所有等待集中的线程
    }

    public synchronized int getBalance(int fromAcc) {
        int balance = 100;
        System.out.println("账户" + fromAcc + "余额" + balance);
        return balance;
    }
}
