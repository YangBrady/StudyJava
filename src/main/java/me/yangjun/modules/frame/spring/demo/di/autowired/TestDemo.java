package me.yangjun.modules.frame.spring.demo.di.autowired;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void testGetBean1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/demo/di/autowired/bean.xml");

        Person diAutowired1 = context.getBean("diAutowired1", Person.class);
        System.out.println(diAutowired1);

        Person diAutowired2 = context.getBean("diAutowired2", Person.class);
        System.out.println(diAutowired2);

        Person diAutowired3 = context.getBean("diAutowired3", Person.class);
        System.out.println(diAutowired3);

        Person diAutowired4 = context.getBean("diAutowired4", Person.class);
        System.out.println(diAutowired4);
    }

}
