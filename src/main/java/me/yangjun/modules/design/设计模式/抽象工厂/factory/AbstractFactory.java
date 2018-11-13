package me.yangjun.modules.design.设计模式.抽象工厂.factory;

import me.yangjun.modules.design.设计模式.工厂模式.demo.Shape;
import me.yangjun.modules.design.设计模式.工厂模式.test.Hero;

public abstract class AbstractFactory {
	public abstract Hero getHero(String heroType);

	public abstract Shape getShape(String shapeType);
	// 默认的访问修饰符是不允许跨越包来实现方法的
}
