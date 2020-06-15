package me.yangjun.study.类加载;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 杨峻 on 2016/10/24.
 */
public class Staff{
	public static void main(String[] args) {
		
	}
}

class Employee{
	private String name;
	private double salary;
	private Date hireDay;

	public Employee(String n, double s, int year, int month, int day){
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}

	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}

class Manager extends Employee{
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		// TODO Auto-generated constructor stub
	}
	private double bonus;
	public void setBonus(double b){
		bonus = b;
	}
}