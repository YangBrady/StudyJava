package me.yangjun.study.other;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    public void testOver() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int sum = a + b;
        System.out.println("a=" + a + ", sum=" + sum); // a=2147483647, sum=-2
    }
}
