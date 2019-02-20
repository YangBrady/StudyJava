package me.yangjun.modules.frame.spring.demo.jdbc.sessionctrl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    /**
     * Service的方法报错后整个方法的事务都回滚
     */
    @Test
    public void testDemo001() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/sessionctrl/applicationContext.xml");
        TestService testService = (TestService) ac.getBean("testService");
        testService.saveData();
    }

    /**
     * Service的方法报错后整个方法的事务都回滚（使用注解）
     */
    @Test
    public void testDemo002() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/sessionctrl/applicationContext2.xml");
        TestService2 testService2 = (TestService2) ac.getBean("testService2");
        testService2.saveData();
    }

    /**
     * 通过一个没有事务的方法调用一个有事务的方法（不会回滚）
     */
    @Test
    public void testDemo003() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/sessionctrl/applicationContext2.xml");
        TestService2 testService2 = (TestService2) ac.getBean("testService2");
        testService2.callSaveData();
    }
}
