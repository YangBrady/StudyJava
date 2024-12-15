package me.yangjun.study.spring.spel;

import me.yangjun.study.spring.spel.po.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpringEL {
    @Test
    public void test001() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#root.orderName");
        Order order = new Order();
        order.setOrderName("张三");
        System.out.println(expression.getValue(order));
    }

    @Test
    @DisplayName("上下文测试")
    public void test002() {
        Order order = new Order();
        order.setOrderName("张三");

        EvaluationContext context = new StandardEvaluationContext();
        // 1、设置变量
        context.setVariable("order", order);
        ExpressionParser parser = new SpelExpressionParser();
        // 2、表达式中以#varName的形式使用变量
        Expression expression = parser.parseExpression("#order.orderName");
        // 3、在获取表达式对应的值时传入包含对应变量定义的EvaluationContext
        String orderName = expression.getValue(context, String.class);
        // 表达式中使用变量，并在获取值时传递包含对应变量定义的EvaluationContext。
        Assertions.assertEquals("张三", orderName);
    }
}
