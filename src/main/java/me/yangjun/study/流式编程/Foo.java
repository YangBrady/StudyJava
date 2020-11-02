package me.yangjun.study.流式编程;

/**
 * @author mooejun
 * @since 2019/11/27
 */
public class Foo {
    private int code;

    private int count;

    public Foo() {
    }

    public Foo(int code, int count) {
        this.code = code;
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}