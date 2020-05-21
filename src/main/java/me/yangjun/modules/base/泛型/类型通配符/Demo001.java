package me.yangjun.modules.base.泛型.类型通配符;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mooejun
 * @since 2019/11/19
 */
public class Demo001 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 编译通过但是破坏了类型安全
        deal001(list);

        // 编译失败
        // deal002(list);

        // 正确方式
        deal003(list);
    }

    private static void deal001(List list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    private static void deal002(List<Object> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    private static void deal003(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
