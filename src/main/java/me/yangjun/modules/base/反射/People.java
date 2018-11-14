package me.yangjun.modules.base.反射;

public class People {
	private String firstName;
	private int age;
	private char sex;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void methodA() {
		System.out.println("1");
	}

	public People(String firstName, int age, char sex) {
		super();
		this.firstName = firstName;
		this.age = age;
		this.sex = sex;
	}

	public People() {
		super();
	}
}
