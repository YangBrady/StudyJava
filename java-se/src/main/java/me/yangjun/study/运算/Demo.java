package me.yangjun.study.运算;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author mooejun
 * @since 2020/6/17 2:06 下午
 */
@Slf4j
public class Demo {

    /**
     * 运算符优先级
     */
    @Test
    public void demo001() {
        System.out.println(10 % 3 * 2);
    }

    @Test
    public void testBigDecimalZero() {
        BigDecimal a = new BigDecimal("10000.000");
        log.info("BigDecimal toString={}", a);// 10000.000
        log.info("BigDecimal stripTrailingZeros={}", a.stripTrailingZeros());// 1E+4
        log.info("BigDecimal toPlainString={}", a.toPlainString());// 10000.000
        log.info("BigDecimal stripTrailingZeros + toPlainString={}", a.stripTrailingZeros().toPlainString());// 10000
    }
}
