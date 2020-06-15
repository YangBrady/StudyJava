package me.yangjun.study.面向对象.内部类.成员内部类;

/**
 * 成员内部类
 *
 * @author mooejun
 * @since 2019-03-16
 */
public class Circle {
    private double radius = 0;
    public static int count = 1;

    public Circle(double radius) {
        this.radius = radius;
    }

    // 可以加上访问修饰符
    public class Draw { // 成员内部类
        public void drawSahpe() {
            System.out.println("radius=" + radius + ", count=" + count); // 外部类的private成员和外部类的静态成员
        }
    }

    public Draw getInstance() {
        return new Draw();
    }

}
