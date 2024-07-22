package me.yangjun.study.集合类.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mooejun
 * @since 2019/4/22
 */
@Slf4j
public class TestDemo {

    /**
     * get不存在的key会返回null而不是空指针
     */
    @Test
    public void getNull() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        System.out.println(map.get("b"));
    }

    /**
     * Java8新特性 - merge 通过lambda表达式
     */
    @Test
    public void merge() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("a", "aaa");
        String str = "哈哈哈";
        // if (testMap.get("a") == null) {
        // testMap.put("a", str);
        // } else {
        // testMap.put("a", testMap.get("a") + "," + str);
        // }

        // 效果和注释是一样的
        testMap.merge("a", str, (a, b) -> a + "," + b);
        System.out.println(testMap);
    }

    /**
     * Put测试
     */
    @Test
    public void testPut() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, String> testMap = new HashMap<>();
        Method capacity = testMap.getClass().getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        Integer realCapacity = (Integer) capacity.invoke(testMap);

        log.info("put之前：{}", realCapacity);
        testMap.put("a", "aaa");
        log.info("put之后：{}", realCapacity);
    }
}
