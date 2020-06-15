package me.yangjun.study.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Spring 3.2 开始支持 方法级别的 profile
 *
 * @author mooejun
 * @since 2019/06/09
 */

@Configuration
public class ProfileMix {

    @Bean
    @Profile("dev")
    public String userName1() {
        return "dev";
    }

    @Bean
    @Profile("prod")
    public String userName2() {
        return "prod";
    }

    // 未指定profile的始终会被创建
    @Bean
    public String userName3() {
        return "no";
    }
}
