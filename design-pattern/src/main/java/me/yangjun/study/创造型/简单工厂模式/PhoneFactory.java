package me.yangjun.study.创造型.简单工厂模式;

/**
 * @author mooejun
 * @since 2020/06/28 16:35
 */
public class PhoneFactory {
	public Phone getPhone(String phoneType) {
		if (phoneType.equalsIgnoreCase("MI")) {
			return new MiPhone();
		} else if (phoneType.equalsIgnoreCase("OPPO")) {
			return new OppoPhone();
		}
		return null;
	}
}
