package me.yangjun.study.其他;

import org.junit.Test;

/**
 * @author mooejun
 * @since 2019/4/19
 */
public class BaseDemo {

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
}
