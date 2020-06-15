package me.yangjun.study.抽象工厂.factoryImp;

import me.yangjun.study.抽象工厂.bean.*;
import me.yangjun.study.抽象工厂.factory.AbstractFactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	// TODO Auto-generated method stub
	public Hero getHero(String heroType) {
		return null;
	}

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		} else if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

}
