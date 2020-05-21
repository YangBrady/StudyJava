package me.yangjun.modules.frame.spring.demo.ioc.bean;

/**
 * @author mooejun
 * @since 2020/03/01
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
	private String brand;
	private String color;
	private int maxSpeed;
	private BeanFactory beanFactory;
	private String beanName;

	// 管理Bean生命周期的接口
	public Car() {
		System.out.println("调用Bean自身的方法 Car构造函数");
	}
	public void setBrand(String brand) {
		System.out.println("调用Bean自身的方法 setBrand()设置属性");
		this.brand = brand;
	}

	// BeanNameAware接口方法
	public void setBeanName(String beanName) {
		System.out.println("调用Bean级生命周期接口方法 BeanNameAware.setBeanName()");
		this.beanName = beanName;
	}
	// BeanFactoryAware接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用Bean级生命周期接口方法 BeanFactoryAware.setBeanFactory()");
		this.beanFactory = beanFactory;
	}
	// initializingBean接口方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用Bean级生命周期接口方法 InitializingBean.afterPropertiesSet()");
	}
	// DisposableBean接口方法
	public void destroy() throws Exception {
		System.out.println("调用Bean级生命周期接口方法 DisposableBean.destroy()");
	}


	// 通过<bean>的init-method属性指定的初始化方法
	public void myInit() {
		System.out.println("调用Bean自身的方法 inti-method所指定的myInit(),将maxSpeed设置为240.");
		this.maxSpeed = 240;
	}
	// 通过<bean>的destory-method属性指定的销毁方法
	public void myDestory() {
		System.out.println("调用Bean自身的方法 destory-method所指定的myDestory()方法。");
	}

	@Override
	public String toString() {
		return "Car{" +
				"brand='" + brand + '\'' +
				", color='" + color + '\'' +
				", maxSpeed=" + maxSpeed +
				'}';
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getBrand() {
		return brand;
	}
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}
	public String getBeanName() {
		return beanName;
	}
}