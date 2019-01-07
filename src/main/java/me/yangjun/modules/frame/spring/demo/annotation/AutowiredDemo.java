package me.yangjun.modules.frame.spring.demo.annotation;

import me.yangjun.modules.frame.spring.demo.annotation.bean.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredDemo {

    @Test
    public void testDemo001() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/demo/annotation/bean.xml");
        Cat cat = (Cat) context.getBean("cat");
        cat.play();
        cat.eat();
        cat.showSkill();
    }
}
