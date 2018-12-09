package me.yangjun.modules.frame.spring.demo.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangjun on 2018/12/6.
 */
public class TestDemo {

    @Test
    public void testGetBean1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/demo/ioc/bean.xml");

        MalePerson malePerson1 = context.getBean("malePerson1", MalePerson.class);
        System.out.println(malePerson1.getLength());

        MalePerson malePerson2 = context.getBean("malePerson2", MalePerson.class);
        System.out.println(malePerson2.getLength());

        MalePerson malePerson3 = context.getBean("malePerson3", MalePerson.class);
        System.out.println(malePerson3.getLength());

    }
}
