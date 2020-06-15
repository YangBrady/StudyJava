package me.yangjun.study.annotation;

import me.yangjun.study.annotation.bean.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredDemo {

    @Test
    public void testDemo001() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:annotation/bean.xml");
        Cat cat = (Cat) context.getBean("cat");
        cat.play();
        cat.eat();
        cat.showSkill();
    }
}
