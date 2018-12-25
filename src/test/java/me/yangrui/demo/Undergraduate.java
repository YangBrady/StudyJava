package me.yangrui.demo;

public class Undergraduate extends Student {
	protected String specialty;

	@Override
	public String toString() {
		return "Undergraduate [name=" + super.name + ", age=" + super.age + ", degree=" + super.degree + "specialty="
				+ specialty + "]";
	}
}
