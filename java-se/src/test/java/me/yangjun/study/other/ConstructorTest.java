package me.yangjun.study.other;

public class ConstructorTest {
	private String name;
	private int age;

	public ConstructorTest(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public ConstructorTest() {
		super();
	}
}
