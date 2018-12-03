package me.yangjun.modules.frame.spring.demo01.impl;

import me.yangjun.modules.frame.spring.demo01.HelloApi;

public class HelloApiImpl implements HelloApi {

	@Override
	public void sayHello() {
		System.out.println("Hello World");
	}

}
