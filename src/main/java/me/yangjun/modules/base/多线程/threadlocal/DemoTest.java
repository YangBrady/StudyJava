package me.yangjun.modules.base.多线程.threadlocal;

import java.text.SimpleDateFormat;

/**
 * @author mooejun
 * @since 2020/04/15
 */
public class DemoTest {

	public static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public static void main(String[] args) {

	}
}
