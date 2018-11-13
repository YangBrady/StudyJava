package me.yangjun.modules.base.枚举;

public class UseEnum {

	public static void main(String[] args) {
		Color color = Color.BLACK; // 获取枚举类实例
		System.out.println(color);

		System.out.println("---------------values---------------");
		Color[] colors = Color.values();// values 静态方法，返回一个包含全部枚举值的数组
		for (Color c : colors) {
			System.out.println(c + ",");
		}

		System.out.println("---------------valueOf---------------");
		System.out.println(Color.valueOf("BLUE")); // valueOf

		System.out.println("---------------equals---------------");
		System.out.println(Color.BLACK.equals(Color.BLUE)); // equals

		System.out.println("---------------compareTo---------------");
		System.out.println(Color.BLACK.compareTo(Color.BLUE)); // compareTo

		System.out.println("---------------switch语句---------------");
		switch (color) {
		case RED:
			System.out.println("it‘s red");
			break;
		case BLUE:
			System.out.println("it’s blue");
			break;
		case BLACK:
			System.out.println("it‘s black");
			break;
		default:
			break;
		}
	}
}
