package me.yangjun.modules.frame.spring.demo.jdbc.service.jdbctemplate;

import me.yangjun.modules.frame.spring.demo.jdbc.bean.TestBean;
import me.yangjun.modules.frame.spring.demo.jdbc.dao.impl.TestDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用JDBC Template
 */
public class TestDemo {

    private static ApplicationContext ac;

    static {
        ac = new ClassPathXmlApplicationContext("classpath*:spring/demo/jdbc/applicationContext.xml");
    }

    /**
     * 插入数据
     */
    @Test
    public void testDemo001() {
        TestBean aTestBean = new TestBean();
        aTestBean.setName("嘻嘻");
        aTestBean.setSex("1");
        TestDao testDao = (TestDao) TestDemo.ac.getBean("testDao");
        testDao.save(aTestBean);
    }

    /**
     * 查询数据
     */
    @Test
    public void testDemo002() {
        TestDao testDao = (TestDao) TestDemo.ac.getBean("testDao");
        testDao.query("1");
    }
}
