package me.yangjun.study.接口;

public interface InterfaceA {
    static void doC() {}

    public void doA();

    default void doB() {}
}