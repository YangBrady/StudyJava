package me.yangjun.study.工厂模式.test;

public class Test {
	public static void main(String[] args) {
		HeroFactory hf = new HeroFactory();
		Hero h1 = hf.getHero("demahero");
		h1.skill();
	}
}
