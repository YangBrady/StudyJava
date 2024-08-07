package me.yangjun.study.泛型.泛型类;

import org.junit.jupiter.api.Test;

/**
 * @author mooejun
 * @since 2019/05/28
 */
public class GenericClass01Test {
    @Test
    public void demo() {
        GenericClass01<String> gc1 = new GenericClass01<>();
        gc1.setKey("aaa");
        System.out.println(gc1.getKey());

        GenericClass01<Integer> gc2 = new GenericClass01<>();
        gc2.setKey(123456);
        System.out.println(gc2.getKey());
    }
}
