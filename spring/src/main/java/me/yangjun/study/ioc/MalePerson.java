package me.yangjun.study.ioc;

/**
 * Created by yangjun on 2018/12/6.
 */
public class MalePerson extends Person {
    private String length;

    public MalePerson() {
    }

    public MalePerson(String length) {
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

}
