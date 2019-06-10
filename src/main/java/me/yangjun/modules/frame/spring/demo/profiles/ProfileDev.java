package me.yangjun.modules.frame.spring.demo.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Spring 3.1 开始支持 bean profile
 *
 * @author mooejun
 * @since 2019/06/09
 */

@Configuration
@Profile("dev") // 当前类中的bean只有在dev profile激活时才会创建
public class ProfileDev {

    @Bean
    public String userName() {
        return "dev";
    }
}
