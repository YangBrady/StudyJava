package me.yangjun.study.jdbc.service.sessionctrl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

	private static TestService aTestService;

	static {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:jdbc/applicationContext.xml");
		aTestService = (TestService) ac.getBean("testService");
	}

	@Test
	public void normalSave() {
		aTestService.normalSave();
		try {
			aTestService.normalSaveError();
		} catch (Exception e) {}

		aTestService.sessionRequired();
		try {
			aTestService.sessionRequiredError();
		} catch (Exception e) {}


		try {
			aTestService.sessionNotSupportedError();
		} catch (Exception e) {}

		try {
			aTestService.sessionReadOnly();
		} catch (Exception e) {}
	}
}
