package me.yangjun.study.创造型.简单工厂模式;

/**
 * @author mooejun
 * @since 2020/06/28 16:34
 */
public class OppoPhone implements Phone {
	@Override
	public void call() {
		System.out.println("OPPO 手机");
	}
}
