package me.yangjun.modules.frame.spring.demo.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCTest {

    @Test
    public void testDemo001() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/applicationContext.xml");
        TestDao testDao = (TestDao) ac.getBean("testDao");
        testDao.save();
    }

}
