package me.yangjun.study.config.parser.spel;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.BeanFactory;
// import org.springframework.cache.interceptor.CacheExpressionRootObject;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 * SpEL 解析类 CacheOperationExpressionEvaluator
 */
@Component
public class AutoLogExpressionEvaluator extends CachedExpressionEvaluator {

    /**
     * Indicate that there is no result variable.
     */
    public static final Object NO_RESULT = new Object();

    /**
     * Indicate that the result variable cannot be used at all.
     */
    public static final Object RESULT_UNAVAILABLE = new Object();

    /**
     * The name of the variable holding the result object.
     */
    public static final String RESULT_VARIABLE = "result";

    /**
     * 表达式缓存 缓存方法、表达式和 SpEL 的 Expression 的对应关系，让方法注解上添加的 SpEL 表达式只解析一次
     */
    private final Map<ExpressionKey, Expression> expressionCache = new ConcurrentHashMap<>(64);

    /**
     * 缓存传入到 Expression 表达式的 Object
     */
    private final Map<AnnotatedElementKey, Method> targetMethodCache = new ConcurrentHashMap<>(64);

    /**
     * 解析表达式 从 expressionCache 中获取到 @LogRecordAnnotation 注解上的表达式的解析 Expression 的实例， 然后调用 getValue 方法， getValue 传入一个
     * evalContext 就是类似上面例子中的 order 对象
     *
     * @param conditionExpression 条件表达式
     * @param methodKey 方法键
     * @param evalContext 评估上下文，这里可以传入 LogRecordEvaluationContext
     * @return 解析后的结果值
     */
    public String parseExpression(String conditionExpression, AnnotatedElementKey methodKey,
        EvaluationContext evalContext) {
        Expression expression = super.getExpression(this.expressionCache, methodKey, conditionExpression);
        return expression.getValue(evalContext, String.class);
    }

    /**
     * 创建上下文，用来给 SpEL 解析方法参数和 Context 中的变量
     *
     * @param method 方法
     * @param args 参数
     * @param targetClass 目标类别
     * @param result 结果
     * @param errorMsg 错误信息
     * @param beanFactory bean工厂
     * @return {@link EvaluationContext }
     */
    public EvaluationContext createEvaluationContext(Method method, Object[] args, Class<?> targetClass, Object result,
        String errorMsg, BeanFactory beanFactory) {
        // CacheExpressionRootObject rootObject = new CacheExpressionRootObject(
        //         caches, method, args, target, targetClass);

        AuditEvaluationContext evaluationContext =
            new AuditEvaluationContext(null, method, args, getParameterNameDiscoverer(), result, errorMsg);
        if (beanFactory != null) {
            evaluationContext.setBeanResolver(new BeanFactoryResolver(beanFactory));
        }
        return evaluationContext;
    }
}