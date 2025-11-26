package me.yangjun.study.oop.innerclass.成员内部类;

/**
 * 成员内部类
 *
 * @author mooejun
 * @since 2019-03-16
 */
public class Circle {
    public static int count = 1;
    private double radius = 0;
    public double a = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public class Draw {
        public double a = 10;

        public void drawShape() {
            System.out.println("radius=" + radius + ", count=" + count); // 外部类的private成员和外部类的静态成员
        }

        public void printA() {
            System.out.println(Circle.this.a);
            System.out.println(a);
        }
    }

    public Draw getDrawInstance() {
        return new Draw();
    }
}
