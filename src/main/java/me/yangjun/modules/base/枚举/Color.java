package me.yangjun.modules.base.枚举;

public enum Color {
	// 所有的枚举值都是类静态常量
	RED(255, 0, 0), BLUE(0, 0, 255), BLACK(0, 0, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0);
	
	private int redValue; // 自定义数据域，private为了封装。
	private int greenValue;
	private int blueValue;

	// 构造器只是在构造枚举值的时候被调用。
	// 构造枚举值，比如RED(255，0，0)，枚举构造器只能是私有的
	private Color(int rv, int gv, int bv) {
		this.redValue = rv;
		this.greenValue = gv;
		this.blueValue = bv;
	}

	public String toString() { // 覆盖了父类Enum的toString()
		return super.toString() + "(" + redValue + "," + greenValue + "," + blueValue + ")";
		// 不重写的话会只返回 BLACK 而不是 BLACK(0, 0, 0)
	}
}
