package me.yangjun.study.ioc.bean;

/**
 * @author mooejun
 * @since 2020/03/01
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	// 接口方法：实例化bean前进行调用
	@Override
	public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
		// 1-1仅对容器中的car-bean进行处理
		if ("car".equals(beanName)) {
			System.out.println("Bean级生命周期接口方法 InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation()");
		}
		return null;
	}

	// 接口方法：在实例化bean后进行调用
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if ("car".equals(beanName)) {
			System.out.println("Bean级生命周期接口方法 InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation()");
		}
		return true;
	}

	// 接口方法:在设置某个属性时调用
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues propertyvalues,
	                                                PropertyDescriptor apropertydescriptor[],
	                                                Object bean, String beanName) throws BeansException {
		// 3-1仅对容器中car-bean进行处理，还可以通过post入参进行过滤， 仅对car的某个特定属性进行处理
		if ("car".equals(beanName)) {
			System.out.println("Bean级生命周期接口方法 InstantiationAwareBeanPostProcessor.postProcessPropertyValues()");
		}
		return propertyvalues;
	}
}