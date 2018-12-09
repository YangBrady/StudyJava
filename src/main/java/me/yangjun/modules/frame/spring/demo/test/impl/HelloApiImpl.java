package me.yangjun.modules.frame.spring.demo.test.impl;

import me.yangjun.modules.frame.spring.demo.test.HelloApi;

public class HelloApiImpl implements HelloApi {

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }

}
