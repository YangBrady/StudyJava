package me.yangjun.modules.base.面向对象.内部类.局部内部类;

/**
 * @author mooejun
 * @since 2019/3/16
 */
public class Person {
    public Person() {
    }

    public void getSomething() {
        // 没有访问修饰符
        class Food {
            // JDK1.8以前，局部内部类调用的局部变量必须是final修饰的。
            int age = 0;
            public int getAge() {
                return this.age;
            }
        }
    }
}
