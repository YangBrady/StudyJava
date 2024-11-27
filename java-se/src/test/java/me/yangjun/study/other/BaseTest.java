package me.yangjun.study.other;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author mooejun
 * @since 2019/4/19
 */
public class BaseTest {

    @Test
    public void demo001() {
        String a_ = "";
        String a_null = null;
        String a = "a";

        String b_ = "";
        String b_null = null;
        String b = "b";

        String result = (a == null || a.equals("") ? (b == null || b.equals("") ? "" : "") : "");
    }

    /**
     * 1. Java中是值传递
     * 2. 当传递一个对象引用给方法时，方法中修改引用地址不会生效，因为传递过去的是对象的引用的副本而不是原对象的引用
     */
    @Test
    public void referencesDemo001() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        System.out.println(list); // 地址是 1710

        change1(list);
        System.out.println(list); // 地址是 1710

        change2(list);
        System.out.println(list); // 地址是 1710
    }

    private static void change1(List<Integer> list) {
        list = list.subList(list.size() - 2, list.size());
        System.out.println(list); // 地址是 1707
    }

    private static void change2(List<Integer> list) {
        list.add(5);
        System.out.println(list); // 地址是 1710
    }

}
