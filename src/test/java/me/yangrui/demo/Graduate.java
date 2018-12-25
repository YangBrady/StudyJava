package me.yangrui.demo;

public class Graduate extends Student {
	protected String direction;

	@Override
	public String toString() {
		return "Graduate [name=" + super.name + ", age=" + super.age + ", degree=" + super.degree + "direction="
				+ direction + "]";
	}
}
