package me.yangjun.modules.frame.spring.demo.jdbc.service.sessionctrl;

import me.yangjun.modules.frame.spring.demo.jdbc.bean.TestBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void testDemo001() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/applicationContext.xml");
        TestService aTestService = (TestService) ac.getBean("testService");
        TestBean aTestBean = new TestBean("东东", "1");
        aTestService.normalErrorSave(aTestBean);
    }

    @Test
    public void testDemo002() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/applicationContext2.xml");
        TestService aTestService = (TestService) ac.getBean("testService");
        TestBean aTestBean = new TestBean("东东", "1");
        aTestService.sessionSave(aTestBean);
    }


    @Test
    public void testDemo003() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/applicationContext2.xml");
        TestService aTestService = (TestService) ac.getBean("testService");
        TestBean aTestBean = new TestBean("东东", "2");
        aTestService.sessionErrorSave(aTestBean);
    }

    /**
     * 通过一个没有事务的方法调用一个有事务的方法（不会回滚）
     */
}
