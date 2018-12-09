package me.yangjun.modules.frame.spring.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	@Test
	public void testHelloApi() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo01/hello.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/demo/test/hello.xml");
		HelloApi helloApi = context.getBean("helloApi", HelloApi.class);
		helloApi.sayHello();
	}
}
