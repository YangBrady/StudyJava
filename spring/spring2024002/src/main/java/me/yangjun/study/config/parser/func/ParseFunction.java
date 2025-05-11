package me.yangjun.study.config.parser.func;

public interface ParseFunction {
    String functionName();

    /**
     * 执行方法获取方法返回值
     */
    String apply(String value);
}