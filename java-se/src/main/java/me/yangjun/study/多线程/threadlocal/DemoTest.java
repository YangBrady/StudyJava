package me.yangjun.study.多线程.threadlocal;

import java.text.SimpleDateFormat;

/**
 * @author mooejun
 * @since 2020/04/15
 */
public class DemoTest {

	public static final ThreadLocal<SimpleDateFormat> dateFormat =
		ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

	public static void main(String[] args) {

	}
}
