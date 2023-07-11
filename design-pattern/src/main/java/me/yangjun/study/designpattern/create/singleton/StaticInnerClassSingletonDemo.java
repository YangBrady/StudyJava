package me.yangjun.study.designpattern.create.singleton;

/**
 * 静态内部类<br>
 * <pre>
 *     这种方式 StaticInnerClassSingletonDemo 类被装载了，INSTANCE 不一定被初始化。
 *     因为 SingletonHolder 类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载 SingletonHolder 类，从而实例化 INSTANCE
 *     如果实例化 INSTANCE 很消耗资源，这种方式可以延迟加载
 * </pre>
 */
public class StaticInnerClassSingletonDemo {
    private StaticInnerClassSingletonDemo() {
    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingletonDemo INSTANCE = new StaticInnerClassSingletonDemo();
    }

    public static StaticInnerClassSingletonDemo getInstance() {
        return SingletonHolder.INSTANCE;
    }
}