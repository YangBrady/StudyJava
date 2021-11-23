package me.yangjun.study.oom;

import java.util.HashMap;
import java.util.Map;

public class TestMain {
    // 声明缓存对象
    private static final Map<String, TestMemoryObj> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("-------");
        try {
            // 给打开visualvm时间
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 循环添加对象到缓存
        for (int i = 0; i < 4000000; i++) {
            TestMemoryObj t = new TestMemoryObj();
            map.put("key" + i, t);
            System.out.println("i=" + i);
        }
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------");
    }

}

class TestMemoryObj {
    public String name = "abc";
    public String address = "abc-def";
}