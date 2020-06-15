package me.yangjun.study.反射;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Student类的名称是：" + Student.class.getName());
		System.out.println("Student类的共有方法：" + Student.class.getMethods());
		System.out.println("Student类的所有方法：" + Student.class.getDeclaredMethods());
		System.out.println("Student类的所有属性：" + Student.class.getDeclaredFields());
		// Student.class.getConstructor();

		try {
			People people = Student.class.getConstructor(new Class[] {}).newInstance(new Object[] {});
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
