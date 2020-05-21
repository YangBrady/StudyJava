package me.yangjun.modules.frame.spring.demo.aop.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    /**
     * 目标对象有接口
     */
    @Test
    public void testDemo001() {
        ApplicationContext ac =
            new ClassPathXmlApplicationContext("classpath*:spring/demo/aop/annotation/applicationContext.xml");
        //这里得到的是代理对象....
        IUser iUser = (IUser) ac.getBean("userDao");
        System.out.println(iUser.getClass());
        iUser.save();
    }

    /**
     * 目标对象没有接口
     */
    @Test
    public void testDemo002() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:spring/demo/aop/annotation/applicationContext.xml");
        OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
        System.out.println(orderDao.getClass());
        orderDao.save();
    }
}
