package me.yangjun.study.多线程.生命周期.休眠;

/**
 * @author mooejun
 * @since 2019/05/21
 */
public class Haha {
    private String name;

    public Haha(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Haha{" +
                "name='" + name + '\'' +
                '}';
    }
}
