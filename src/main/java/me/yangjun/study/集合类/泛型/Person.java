package me.yangjun.study.集合类.泛型;

import org.junit.Test;

/**
 * 泛型
 *
 * @author mooejun
 * @since 2019-03-05
 */
public class Person<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Test
    public void testDemo001() {
        Person<String> person = new Person<String>();
    }
}
