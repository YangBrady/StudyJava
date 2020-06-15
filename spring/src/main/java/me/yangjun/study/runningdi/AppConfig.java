package me.yangjun.study.runningdi;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author mooejun
 * @since 2019/06/10
 */

@Configuration
@PropertySource("classpath:runningdi/a.properties")
public class AppConfig {

}
