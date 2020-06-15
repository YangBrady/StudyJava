package me.yangjun.study.抽象工厂;

import me.yangjun.study.抽象工厂.bean.Hero;
import me.yangjun.study.抽象工厂.bean.Shape;
import me.yangjun.study.抽象工厂.factory.AbstractFactory;

public class Test {

	public static void main(String[] args) {
		AbstractFactory heroFactory = FactoryProduct.getFactory("HERO");
		AbstractFactory shapeFactory = FactoryProduct.getFactory("SHAPE");

		Hero h1 = heroFactory.getHero("DEMAHERO");
		h1.skill();
		
		Shape s1 = shapeFactory.getShape("CIRCLE");
		s1.draw();
	}
}
