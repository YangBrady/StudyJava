package me.yangjun.modules.base.多线程.生命周期.休眠;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mooejun
 * @since 2019/05/21
 */
public class ThreadA implements Runnable {

    public static Map<String, Haha> map = new HashMap<>();

    @Override
    public void run() {
        while (true) {
            System.out.println(map.get("haha").getName());
        }
    }
}
