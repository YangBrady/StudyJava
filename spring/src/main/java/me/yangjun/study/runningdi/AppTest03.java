package me.yangjun.study.runningdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringEL(SpEL)
 *
 * @author mooejun
 * @since 2019/06/10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppTest03 {

    @Value("#{1234}")
    private int a;

    @Value("#{'Hello'}")
    private String b;

    @Value("#{T(java.lang.Math).random()}")
    private double d;

    @Test
    public void demo001() {
        System.out.println();
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
    }
}
