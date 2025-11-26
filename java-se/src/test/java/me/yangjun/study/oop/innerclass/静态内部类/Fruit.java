package me.yangjun.study.oop.innerclass.静态内部类;

import lombok.Getter;
import lombok.Setter;

/**
 * Static inner class 静态内部类
 *
 * @author mooejun
 * @since 2019/3/18
 */
@Getter
@Setter
public class Fruit {
    private int age;

    // 不用依赖外部类
    @Getter
    @Setter
    public static class Water {
        private int color;
    }
}
