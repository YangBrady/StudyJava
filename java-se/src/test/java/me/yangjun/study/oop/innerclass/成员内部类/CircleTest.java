package me.yangjun.study.oop.innerclass.成员内部类;

import org.junit.jupiter.api.Test;

/**
 * 创建内部类对象
 * 外部类访问内部类必须先创建内部类对象
 *
 * @author mooejun
 * @since 2019/3/16
 */
public class CircleTest {

    // 第一种方式
    @Test
    public void demo001() {
        Circle circle = new Circle(1);

        Circle.Draw draw1 = circle.new Draw();
        draw1.drawShape();
        draw1.printA();
    }

    // 第二种方式
    @Test
    public void demo002() {
        Circle circle = new Circle(1);
        Circle.Draw draw2 = circle.getDrawInstance();
        draw2.drawShape();

    }
}
