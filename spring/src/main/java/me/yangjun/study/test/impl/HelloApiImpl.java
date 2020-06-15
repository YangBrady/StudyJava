package me.yangjun.study.test.impl;

import me.yangjun.study.test.HelloApi;

public class HelloApiImpl implements HelloApi {

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }

}
