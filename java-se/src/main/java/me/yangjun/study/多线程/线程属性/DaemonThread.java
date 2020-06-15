package me.yangjun.study.多线程.线程属性;

/**
 * 守护线程
 *
 * @author mooejun
 * @since 2019/06/29
 */
public class DaemonThread {
    public static void main(String[] args) {

        // 守护线程先设置后运行
        Thread daemon = new Thread(() -> System.out.println("hello"));
        daemon.setDaemon(true);
        daemon.start();

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("xixi");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}
