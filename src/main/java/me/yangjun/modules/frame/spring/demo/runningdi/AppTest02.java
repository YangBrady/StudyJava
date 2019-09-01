package me.yangjun.modules.frame.spring.demo.runningdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 解析属性占位符
 *
 * @author mooejun
 * @since 2019/06/10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppTest02 {

    @Value("${bb}")
    private String bb;

    @Test
    public void demo001() {
        System.out.println(bb);
    }
}
