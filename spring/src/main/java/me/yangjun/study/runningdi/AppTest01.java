package me.yangjun.study.runningdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mooejun
 * @since 2019/06/10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppTest01 {

    @Autowired
    private Environment environment;

    @Test
    public void demo001() {
        String bb = environment.getProperty("bb");
        System.out.println(bb);
    }
}
