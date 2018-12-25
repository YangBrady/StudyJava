package me.yangjun.modules.base.多线程.创建;

import java.math.BigDecimal;

public class MyThread extends Thread {

	@Override
	public void run() {
		BigDecimal bd0 = new BigDecimal(0);
		BigDecimal totalAmt = new BigDecimal(200000);
		BigDecimal perAmt = new BigDecimal(10000);
		boolean doFlag = true;
		while (doFlag) {
			if (totalAmt.compareTo(bd0) <= 0) {
				doFlag = false;
			}
			totalAmt = totalAmt.subtract(perAmt);
			System.out.println(getName() + "..." + totalAmt);
		}
	}

}
