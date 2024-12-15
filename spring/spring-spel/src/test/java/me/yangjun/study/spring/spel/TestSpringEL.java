package me.yangjun.study.spring.spel;

import me.yangjun.study.spring.spel.po.Order;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestSpringEL {
    @Test
    public void test001() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#root.orderName");
        Order order = new Order();
        order.setOrderName("张三");
        System.out.println(expression.getValue(order));
    }
}
