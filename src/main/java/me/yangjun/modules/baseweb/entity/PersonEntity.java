package me.yangjun.modules.baseweb.entity;

public class PersonEntity {
	private String name;
	private int age;
	private String sex;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "PersonEntity [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public PersonEntity() {
		super();
	}

	public PersonEntity(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
}
