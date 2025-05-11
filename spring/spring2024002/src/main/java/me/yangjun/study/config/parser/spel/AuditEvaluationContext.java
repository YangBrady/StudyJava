package me.yangjun.study.config.parser.spel;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.ParameterNameDiscoverer;

import lombok.Builder;

/**
 * 日志记录 - 解析上下文
 *
 * @author Brady
 * @date 2024/12/15
 */
@Builder
public class AuditEvaluationContext extends MethodBasedEvaluationContext {
    /**
     * 日志记录评估上下文
     *
     * @param rootObject 根对象
     * @param method 方法
     * @param arguments 参数
     * @param parameterNameDiscoverer 参数名称发现者
     * @param ret 返回对象
     * @param errorMsg 错误信息
     */
    public AuditEvaluationContext(Object rootObject, Method method, Object[] arguments,
        ParameterNameDiscoverer parameterNameDiscoverer, Object ret, String errorMsg) {
        // 把方法的参数都放到 SpEL 解析的 RootObject 中
        super(rootObject, method, arguments, parameterNameDiscoverer);

        // 把 LogRecordContext 中的变量都放到 RootObject 中
        Map<String, Object> variables = AuditContext.getVariables();
        if (MapUtils.isNotEmpty(variables)) {
            for (Map.Entry<String, Object> entry : variables.entrySet()) {
                setVariable(entry.getKey(), entry.getValue());
            }
        }

        // 把方法的返回值和 ErrorMsg 都放到 RootObject 中
        setVariable("_ret", ret);
        setVariable("_errorMsg", errorMsg);
    }
}