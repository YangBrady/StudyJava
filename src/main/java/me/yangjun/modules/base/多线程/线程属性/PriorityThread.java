package me.yangjun.modules.base.多线程.线程属性;

/**
 * 线程优先级
 *
 * @author mooejun
 * @since 2019/06/29
 */
public class PriorityThread {
    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("xixi");
                }
            }
        };
        t.setPriority(7);
        t.start();
    }
}
