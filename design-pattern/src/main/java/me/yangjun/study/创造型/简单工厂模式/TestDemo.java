package me.yangjun.study.创造型.简单工厂模式;

/**
 * @author mooejun
 * @since 2020/06/28 16:36
 */
public class TestDemo {
	public static void main(String[] args) {
		PhoneFactory factory = new PhoneFactory();
		Phone phone = factory.getPhone("MI");
		phone.call();
	}
}
