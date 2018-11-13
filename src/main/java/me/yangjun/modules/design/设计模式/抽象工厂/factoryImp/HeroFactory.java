package me.yangjun.modules.design.设计模式.抽象工厂.factoryImp;

import me.yangjun.modules.design.设计模式.工厂模式.demo.Shape;
import me.yangjun.modules.design.设计模式.工厂模式.test.DemaHero;
import me.yangjun.modules.design.设计模式.工厂模式.test.Hero;
import me.yangjun.modules.design.设计模式.工厂模式.test.JianShengHero;
import me.yangjun.modules.design.设计模式.工厂模式.test.ManWangHero;
import me.yangjun.modules.design.设计模式.抽象工厂.factory.AbstractFactory;

public class HeroFactory extends AbstractFactory {

	@Override
	public Hero getHero(String heroType) {
		if (heroType == null) {
			return null;
		} else if (heroType.equalsIgnoreCase("DEMAHERO")) {
			return new DemaHero();
		} else if (heroType.equalsIgnoreCase("JIANSHENGHERO")) {
			return new JianShengHero();
		} else if (heroType.equalsIgnoreCase("MANWANGHERO")) {
			return new ManWangHero();
		}
		return null;
	}

	@Override
	public Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		return null;
	}

}