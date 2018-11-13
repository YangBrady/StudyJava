package me.yangjun.modules.design.设计模式.抽象工厂.factoryImp;

import me.yangjun.modules.design.设计模式.工厂模式.demo.Circle;
import me.yangjun.modules.design.设计模式.工厂模式.demo.Rectangle;
import me.yangjun.modules.design.设计模式.工厂模式.demo.Shape;
import me.yangjun.modules.design.设计模式.工厂模式.demo.Square;
import me.yangjun.modules.design.设计模式.工厂模式.test.Hero;
import me.yangjun.modules.design.设计模式.抽象工厂.factory.AbstractFactory;

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
