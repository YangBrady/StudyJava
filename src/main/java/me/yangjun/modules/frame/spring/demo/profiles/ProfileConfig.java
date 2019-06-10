package me.yangjun.modules.frame.spring.demo.profiles;

import org.springframework.context.annotation.*;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author mooejun
 * @since 2019/06/10
 */

@Configuration
@ImportResource("classpath:spring/demo/profiles/applicationContext.xml")
public class ProfileConfig {
    // java config
//    @Bean
//    @Profile("dev")
//    public String userName1() {
//        return "dev";
//    }
//
//    @Bean
//    @Profile("prod")
//    public String userName2() {
//        return "prod";
//    }

    // xml, 用@ImportResource
}
