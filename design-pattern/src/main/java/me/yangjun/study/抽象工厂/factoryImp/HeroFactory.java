package me.yangjun.study.抽象工厂.factoryImp;

import me.yangjun.study.抽象工厂.bean.*;
import me.yangjun.study.抽象工厂.factory.AbstractFactory;

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