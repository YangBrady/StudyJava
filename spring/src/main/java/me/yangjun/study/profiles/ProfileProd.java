package me.yangjun.study.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author mooejun
 * @since 2019/06/09
 */
@Configuration
@Profile("prod") // 当前类中的bean只有在prod profile激活时才会创建
public class ProfileProd {

    @Bean
    public String userName() {
        return "prod";
    }
}
