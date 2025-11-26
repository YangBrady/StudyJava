package me.yangjun.study.oop.innerclass.局部内部类;

import lombok.Getter;

/**
 * @author mooejun
 * @since 2019/3/16
 */
public class Person {
    public Person() {
    }

    public void getSomething() {
        // 没有访问修饰符，只能是static final
        @Getter
        class Food {
            final int age = 0;
        }
    }
}
