package me.yangjun.modules.design.设计模式.工厂模式.test;

public class HeroFactory {
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
}
