package me.yangjun.modules.base.集合类.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mooejun
 * @since 2019/4/22
 */
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
     * Java8新特性 - merge
     * 通过lambda表达式
     */
    @Test
    public void merge() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("a", "aaa");
        String str = "哈哈哈";
//        if (testMap.get("a") == null) {
//            testMap.put("a", str);
//        } else {
//            testMap.put("a", testMap.get("a") + "," + str);
//        }
        testMap.merge("a", str, (a, b) -> a + "," + b); // 效果和注释是一样的
        System.out.println(testMap);
    }
}
