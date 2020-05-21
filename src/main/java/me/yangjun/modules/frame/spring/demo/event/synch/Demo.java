package me.yangjun.modules.frame.spring.demo.event.synch;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mooejun
 * @since 2020/04/27 11:51
 */
public class Demo {

    @Test
    public void test01() {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("classpath*:spring/demo/event/synch/applicationContext.xml");
        CustomEventPublisher publisher = context.getBean("customEventPublisher", CustomEventPublisher.class);
	    publisher.doPublish("1");
    }
}
