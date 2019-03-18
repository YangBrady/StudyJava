package me.yangjun.modules.base.面向对象.内部类.静态内部类;

/**
 * @author mooejun
 * @since 2019/3/18
 */
public class Fruit {
    private int age;

    // 不用依赖外部类
    public static class Water {
        private int color;
    }
}
