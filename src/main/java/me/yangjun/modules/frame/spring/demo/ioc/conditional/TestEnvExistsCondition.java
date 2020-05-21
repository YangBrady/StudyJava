package me.yangjun.modules.frame.spring.demo.ioc.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义条件 - 判断TestEnv是否存在
 * @author mooejun
 * @since 2020/03/01
 */

public class TestEnvExistsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		Environment env = conditionContext.getEnvironment();
		return env.containsProperty("test"); // 检查 test 属性
	}
}