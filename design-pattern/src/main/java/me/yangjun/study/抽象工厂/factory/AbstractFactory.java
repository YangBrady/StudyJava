package me.yangjun.study.抽象工厂.factory;

import me.yangjun.study.抽象工厂.bean.Hero;
import me.yangjun.study.抽象工厂.bean.Shape;

public abstract class AbstractFactory {
	public abstract Hero getHero(String heroType);

	public abstract Shape getShape(String shapeType);
	// 默认的访问修饰符是不允许跨越包来实现方法的
}
