package me.yangjun.modules.base.多线程.生命周期.休眠;

/**
 * @author mooejun
 * @since 2019/05/21
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new ThreadA());
        a.start();
        a.sleep(3 * 1000);
        ThreadA.map.put("haha", new Haha("heihei"));
    }
}
