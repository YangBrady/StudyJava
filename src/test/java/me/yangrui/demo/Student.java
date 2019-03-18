package me.yangrui.demo;

public class Student {
	protected String name;
	protected int age;
	protected String degree;

	public Student() {
	}

	public Student(String name, int age, String degree) {
		this.name = name;
		this.age = age;
		this.degree = degree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", degree=" + degree + "]";
	}
}
