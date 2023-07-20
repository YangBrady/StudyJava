package me.yangjun.study.designpattern.create.factory.simplefactory;

/**
 * @author mooejun
 * @since 2020/06/28 16:36
 */
public class TestDemo {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone phone = factory.getPhone("MI");
        phone.call();
    }
}
