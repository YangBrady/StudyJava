package me.yangjun.modules.base.面向对象.多态;

/**
 * @author mooejun
 * @since 2019/11/12
 */
public class Test {
    public static void main(String[] args) {
        Hero aHero = new HeroImpl();
        aHero.showSkill(); // 展示技能impl
        aHero.showName(); // 展示名称
    }
}
