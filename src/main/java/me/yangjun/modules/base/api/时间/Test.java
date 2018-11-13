package me.yangjun.modules.base.api.时间;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 杨峻 on 2016/10/20.
 */
public class Test {
	public static void main(String[] args) {
		Test t = new Test();

		// 获取当前时间
		Date date = new Date();

		// 格式化处理 a
		String t1 = t.formatTimeA(date);
		System.out.println("使用A方法格式化：" + t1);

		// 格式化处理 b
		try {
			String t2 = t.formatTimeB(date);
			System.out.println("使用B方法格式化：" + t2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 处理时间
		t.dealTimeA(date);

		t.dealTimeB();

	}

	public String formatTimeA(Date date) {
		String str = DateFormat.getDateInstance(DateFormat.DEFAULT).format(date); // DateFormat是抽象类
		return str;
	}

	public String formatTimeB(Date date) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// Date d = df.parse("2016-10-20");//将字符串转换成时间
		String str = df.format(date);// 将时间转换成字符串
		return str;
	}

	public void dealTimeA(Date date) {
		Calendar cal = Calendar.getInstance(); // Calendar是抽象类
		System.out.println(cal.get(cal.YEAR));

		cal.setTime(date);
		// int year = 2016, month = 10, day = 20, hour = 11, minute = 43, second
		// = 2;
		// cal.setTime(new Date(year, month, day, hour, minute, second)); //方法过期
		System.out.println(cal.getTime());
	}

	public void dealTimeB() {
		GregorianCalendar gc = new GregorianCalendar();
		// gc.setTime(new Date());
		// GregorianCalendar gc2 = new
		// GregorianCalendar(2016,10,20);//year,month,day
		int year = gc.get(gc.YEAR);
		int month = gc.get(gc.MONTH);
		System.out.println(year + " " + month);
		gc.set(Calendar.YEAR, 1994);
		gc.set(Calendar.MONTH, 2);
		gc.set(Calendar.DAY_OF_MONTH, 6);
		System.out.println(gc.get(gc.YEAR) + " " + gc.get(gc.MONTH) + " " + gc.get(gc.DAY_OF_MONTH));
		gc.add(Calendar.MONTH, 1);
		gc.add(Calendar.DAY_OF_MONTH, 9);
		System.out.println(gc.get(gc.YEAR) + " " + gc.get(gc.MONTH) + " " + gc.get(gc.DAY_OF_MONTH));
		System.out.println(gc.getTime());
	}
}
