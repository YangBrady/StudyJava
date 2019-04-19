package me.yangjun.modules.base.api.时间.problem.p001;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mooejun
 * @since 2019/4/19
 *
 * 来源：秒支付发现有一个获取当前日期字符串取到了昨天
 * 测试结果：parse方法确实有问题，但是format没测试出来
 */
public class TestDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new TestSimpleDateFormatThreadSafe().start();
            System.out.println("循环continue");
        }
    }

    @Test
    public void testAssertConcurrent() throws InterruptedException {
        List<Runnable> tasks = new ArrayList<Runnable>(100000);
        for (int i = 0; i < 100000; i++) {
            tasks.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Thread.sleep(20);
//                         System.out.println(DateUtilError.parse("2019-04-19"));
                         System.out.println(DateUtil.parse("2019-04-19"));
//                        String aa = DateUtilError.formatDate(new Date());
//                        if(!aa.equals("2019-04-19")) {
//                            System.out.println("!!!!!!");
//                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        ConcurrencyTestUtil.assertConcurrent("1024tasks", tasks, 10, 1000);
    }
}
