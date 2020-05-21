package me.yangjun.modules.frame.spring.demo.ioc.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author mooejun
 * @since 2020/03/01
 */
@Configuration
public class Config {

	@Bean
	@Conditional(TestEnvExistsCondition.class)
	public TestEnv magicBean() {
		return new TestEnv();
	}
}
