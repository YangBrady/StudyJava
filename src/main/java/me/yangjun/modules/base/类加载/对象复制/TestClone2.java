package me.yangjun.modules.base.类加载.对象复制;

/*
 * 实现Cloneable接口
 * 复制了对象，但是对象中非基本类型的成员变量只是简单的复制了引用
 */
public class TestClone2 {

	public static void main(String[] args) {
		PersonB p1 = new PersonB(22, 'M', new GradeB(3));
		try {
			PersonB p2 = (PersonB) p1.clone();
			System.out.println(p1.equals(p2)); // false
			System.out.println("子对象比较1" + p1.getGrade().equals(p2.getGrade())); // true
			boolean a = p1.getGrade() == p2.getGrade();
			System.out.println("子对象比较2" + a); // true
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}

class GradeB {
	int lever;

	public GradeB(int lever) {
		this.lever = lever;
	}

	public int getLever() {
		return lever;
	}

	public void setLever(int lever) {
		this.lever = lever;
	}

}

class PersonB implements Cloneable {
	private int age;
	private char sex;
	private GradeB grade; // 成员属性中的非基本数据类型也要实现Cloneable方法才行

	public PersonB(int age, char sex, GradeB grade) {
		this.age = age;
		this.sex = sex;
		this.grade = grade;
	}

	public GradeB getGrade() {
		return grade;
	}

	public void setGrade(GradeB grade) {
		this.grade = grade;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString();
	}

}