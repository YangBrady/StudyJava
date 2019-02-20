package me.yangjun.modules.frame.spring.demo.jdbc.jdbctemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    /**
     * 使用JDBC Template插入数据
     */
    @Test
    public void testDemo001() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/jdbctemplate/applicationContext.xml");
        TestDao testDao = (TestDao) ac.getBean("testDao");
        testDao.save();
    }

    /**
     * 使用JDBC Template查询数据
     */
    @Test
    public void testDemo002() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/jdbctemplate/applicationContext.xml");
        TestDao testDao = (TestDao) ac.getBean("testDao");
        testDao.query("1");
    }
}
