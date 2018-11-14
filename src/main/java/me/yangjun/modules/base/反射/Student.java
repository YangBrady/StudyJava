package me.yangjun.modules.base.反射;

public class Student extends People {
	private String stuId;

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public Student(String firstName, int age, char sex, String stuId) {
		super(firstName, age, sex);
		this.stuId = stuId;
	}

	public Student(String firstName, int age, char sex) {
		super(firstName, age, sex);
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + "]";
	}
}
