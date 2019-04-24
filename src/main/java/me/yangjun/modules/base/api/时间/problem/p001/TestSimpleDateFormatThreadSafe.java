package me.yangjun.modules.base.api.时间.problem.p001;

import java.text.ParseException;
import java.util.Date;

/**
 * @author mooejun
 * @since 2019/4/19
 */
public class TestSimpleDateFormatThreadSafe extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                this.join(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            try {
//                System.out.println(this.getName() + ":" + DateUtilError.parse("2019-04-19"));
                System.out.println(this.getName() + ":" + DateUtilError.formatDate(new Date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}