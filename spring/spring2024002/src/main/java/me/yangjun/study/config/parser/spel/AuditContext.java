package me.yangjun.study.config.parser.spel;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 日志记录 - 上下文
 *
 * @author Brady
 * @date 2024/12/15
 */
public class AuditContext {

    /**
     * 栈里面是个 Map，Map 对应了变量的名称和变量的值 用栈是为了兼容多个方法嵌套调用
     */

    private static final InheritableThreadLocal<Stack<Map<String, Object>>> variableMapStack =
        new InheritableThreadLocal<>();

    public static void putEmptySpan() {
        if (Objects.isNull(variableMapStack.get())) {
            variableMapStack.set(new Stack<>());
        }
    }

    public static Map<String, Object> getVariables() {
        return variableMapStack.get().pop();
    }

    public static void clear() {}
    // 其他省略....
}
