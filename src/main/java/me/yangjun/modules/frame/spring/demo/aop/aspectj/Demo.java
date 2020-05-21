package me.yangjun.modules.frame.spring.demo.aop.aspectj;

import me.yangjun.modules.frame.spring.demo.aop.aspectj.service.IDemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mooejun
 * @since 2020/04/24
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("start==========start");

        ApplicationContext ctx =
            new ClassPathXmlApplicationContext("classpath*:spring/demo/aop/aspectj/applicationContext.xml");
        IDemoService demoService = ctx.getBean("demoService", IDemoService.class);
        // demoService.show();
        // demoService.showWithArgs("hi", 7);
        demoService.showWithException("hi", 7);

        System.out.println("end==========end");

    }
}
