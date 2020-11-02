package me.yangjun.study.面向对象.多态;

/**
 * @author mooejun
 * @since 2019/11/12
 */
public class HeroImpl extends Hero {

    private String sex;

    public HeroImpl() {
    }

    public HeroImpl(String sex) {
        this.sex = sex;
    }

    public HeroImpl(String name, String sex) {
        super(name);
        this.sex = sex;
    }

    @Override
    public void showSkill() {
        System.out.println("展示技能impl");
    }

    public static void showName() {
        System.out.println("展示名称impl");
    }
}
