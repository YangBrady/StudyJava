package me.yangjun.study.类加载.对象复制;

/*
 * 直接复制的方式
 */
public class TestClone {

	public static void main(String[] args) {
		PersonA p1 = new PersonA(22, 'M');
		PersonA p2 = p1;
		p2.setAge(23);
		p2.setSex('F');
		System.out.println(p1.toString()); // Person [age=23, sex=F]
		System.out.println(p1.equals(p2)); // true
	}

}

class PersonA {
	private int age;
	private char sex;

	public PersonA(int age, char sex) {
		this.age = age;
		this.sex = sex;
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

	@Override
	public String toString() {
		return "Person [age=" + age + ", sex=" + sex + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
