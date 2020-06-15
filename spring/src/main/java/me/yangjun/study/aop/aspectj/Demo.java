package me.yangjun.study.aop.aspectj;

import me.yangjun.study.aop.aspectj.service.IDemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mooejun
 * @since 2020/04/24
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println("start==========start");

		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("classpath*:aop/aspectj/applicationContext.xml");
		IDemoService demoService = ctx.getBean("demoService", IDemoService.class);
		// demoService.show();
		// demoService.showWithArgs("hi", 7);
		demoService.showWithException("hi", 7);

		System.out.println("end==========end");

	}
}
