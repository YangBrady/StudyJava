package me.yangjun.study.创造型.单例模式;

/**
 * 静态内部类
 * <p>
 * 这种方式是Singleton类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance。
 * 想象一下，如果实例化instance很消耗资源，我想让他延迟加载，
 * 另外一方面，我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，
 * 那么这个时候实例化instance显然是不合适的。
 * 这个时候，这种方式相比第三和第四种方式就显得很合理。
 * </p>
 */
public class SingletonDemo004 {
	private static class SingletonHolder {
		private static final SingletonDemo004 singletonDemo004 = new SingletonDemo004();
	}

	private SingletonDemo004() {
	}

	public static SingletonDemo004 getInstance() {
		return SingletonHolder.singletonDemo004;
	}
}