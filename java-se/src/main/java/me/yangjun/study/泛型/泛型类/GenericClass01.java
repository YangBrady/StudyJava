package me.yangjun.study.泛型.泛型类;

/**
 * @author mooejun
 * @since 2019/05/28
 */

// 此处T可以随便写为任意标识, 常见的如T、E、K、V等形式的参数常用于表示泛型, 但是实例化的时候必须指定
public class GenericClass01<T> {
    // key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
