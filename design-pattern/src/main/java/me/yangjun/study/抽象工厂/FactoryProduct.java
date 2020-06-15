package me.yangjun.study.抽象工厂;

import me.yangjun.study.抽象工厂.factory.AbstractFactory;
import me.yangjun.study.抽象工厂.factoryImp.HeroFactory;
import me.yangjun.study.抽象工厂.factoryImp.ShapeFactory;

public class FactoryProduct {
	public static AbstractFactory getFactory(String choice) {
		if (choice == null) {
			return null;
		} else if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if (choice.equalsIgnoreCase("HERO")) {
			return new HeroFactory();
		}
		return null;
	}
}
