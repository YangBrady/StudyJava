package me.yangjun.study.other;

import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    public void testRound() {
        System.out.println(Math.round(-11.2));// -11
        System.out.println(Math.round(-11.5));// -11
        System.out.println(Math.round(-11.7));// -12
    }

}
