package me.yangjun.study.面向对象.多态;

/**
 * @author mooejun
 * @since 2019/11/12
 */
public class Hero {
    private String name;

    public Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    public void showSkill() {
        System.out.println("展示技能");
    }

    public static void showName() {
        System.out.println("展示名称");
    }
}
