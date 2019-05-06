package me.yangjun.modules.base.集合类.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mooejun
 * @since 2019/4/22
 */
public class TestDemo {

    @Test
    public void test001() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aaa");
        System.out.println(map.get("b"));
    }
}
