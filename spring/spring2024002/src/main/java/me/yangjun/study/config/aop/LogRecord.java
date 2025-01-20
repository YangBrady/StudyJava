package me.yangjun.study.config.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import me.yangjun.study.config.log.LogRecordOperation;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogRecord {
    // 操作日志的文本模板，必填
    String success();

    // 操作日志失败的文本版本
    String fail() default "";

    // 操作人
    String operator() default "";

    // 日志类型
    LogRecordOperation category();

    // 扩展参数，记录操作日志的修改详情
    String detail() default "";

    // 记录日志的条件
    String condition() default "";
}