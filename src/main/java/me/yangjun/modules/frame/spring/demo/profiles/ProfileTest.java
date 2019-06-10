package me.yangjun.modules.frame.spring.demo.profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mooejun
 * @since 2019/06/10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles("prod") // 测试dev环境
public class ProfileTest {


    @Autowired
    private String a;

    @Test
    public void demo001() {
        System.out.println("a=" + a);
    }
}
