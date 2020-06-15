package me.yangjun.study.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	@Test
	public void testHelloApi() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:test/hello.xml");
		HelloApi helloApi = context.getBean("helloApi", HelloApi.class);
		helloApi.sayHello();
	}
}
