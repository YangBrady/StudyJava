package me.yangjun.study.oop.innerclass.静态内部类;

import org.junit.jupiter.api.Test;

public class FruitTest {
    @Test
    public void test01() {
        Fruit f1 = new Fruit();
        Fruit.Water water = new Fruit.Water();
    }
}
