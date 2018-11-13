package me.yangjun.modules.base.类加载.对象复制;

/*
 * 子属性也实现Cloneable接口
 */
public class TestClone3 {

	public static void main(String[] args) {
		PersonC p1 = new PersonC(22, 'M', new GradeC(3));
		try {
			PersonC p2 = (PersonC) p1.clone();
			System.out.println(p1.equals(p2)); // false
			System.out.println("子对象比较1" + p1.getGrade().equals(p2.getGrade())); // false
			boolean a = p1.getGrade() == p2.getGrade();
			System.out.println("子对象比较2" + a); // false
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}

class GradeC implements Cloneable {
	int lever;

	public GradeC(int lever) {
		this.lever = lever;
	}

	public int getLever() {
		return lever;
	}

	public void setLever(int lever) {
		this.lever = lever;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class PersonC implements Cloneable {
	private int age;
	private char sex;
	private GradeC grade; // 成员属性中的非基本数据类型也要实现Cloneable方法才行

	public PersonC(int age, char sex, GradeC grade) {
		this.age = age;
		this.sex = sex;
		this.grade = grade;
	}

	public GradeC getGrade() {
		return grade;
	}

	public void setGrade(GradeC grade) {
		this.grade = grade;
	}

	@Override
	protected PersonC clone() throws CloneNotSupportedException {
		PersonC p = (PersonC) super.clone();
		p.grade = (GradeC) grade.clone();
		return p;
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