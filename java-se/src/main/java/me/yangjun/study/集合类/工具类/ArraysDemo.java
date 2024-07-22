package me.yangjun.study.集合类.工具类;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组演示
 *
 * @author mooejun
 * @date 2023/08/02
 */
@Slf4j
public class ArraysDemo {
    @Test
    public void testAsListProblem() {
        // 数组转的List不是java.util.ArrayList，没有实现AbstractList的remove方法
        String[] flowArr = {"GTS", "BU", "SDT"};
        List<String> testArr = Arrays.asList(flowArr);

        log.debug("testArr={}", testArr);

        testArr.removeIf(s -> s.equalsIgnoreCase("sdt"));
        log.debug(testArr.toString());
    }

    @Test
    public void testAsList() {
        // 数组转的List不是java.util.ArrayList，没有实现AbstractList的remove方法
        String[] flowArr = {"GTS", "BU", "SDT"};

        // 优化方案
        List<String> testArr = new ArrayList<>();
        Collections.addAll(testArr, flowArr);

        log.debug("testArr={}", testArr);

        testArr.removeIf(s -> s.equalsIgnoreCase("sdt"));
        log.debug(testArr.toString());
    }
}
