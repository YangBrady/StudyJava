package me.yangjun.modules.base.字符串;

import org.junit.Test;

/**
 * @author mooejun
 * @since 2019/05/06
 */
public class StringTest {

    @Test
    public void demo001() {
        String a = "abcd.txt";
        String b = a.substring(0, a.lastIndexOf("."));
        System.out.println(b);
    }
}
