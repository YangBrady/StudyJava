package me.yangjun.modules.base.api.时间;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 杨峻 on 2016/10/20.
 */
@Slf4j
public class TestDemo {

    @Test
    public void formatTimeA() {
        String str = DateFormat.getDateInstance(DateFormat.DEFAULT).format(new Date()); // DateFormat是抽象类
        System.out.println(str);
    }

    @Test
    public void formatTimeB() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //将字符串转换成时间
        // Date d = df.parse("2016-10-20");
        // 将时间转换成字符串
        String str = df.format(new Date());
    }

    @Test
    public void dealTimeA() {
        // Calendar是抽象类
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));

        cal.setTime(new Date());
        // int year = 2016, month = 10, day = 20, hour = 11, minute = 43, second
        // = 2;
        // cal.setTime(new Date(year, month, day, hour, minute, second)); //方法过期
        System.out.println(cal.getTime());
    }

    @Test
    public void dealTimeB() {
        GregorianCalendar gc = new GregorianCalendar();
        // gc.setTime(new Date());
        // GregorianCalendar gc2 = new GregorianCalendar(2016,10,20);
        int year = gc.get(Calendar.YEAR);
        int month = gc.get(Calendar.MONTH);
        System.out.println(year + " " + month);
        gc.set(Calendar.YEAR, 1994);
        gc.set(Calendar.MONTH, 2);
        gc.set(Calendar.DAY_OF_MONTH, 6);
        System.out.println(gc.get(Calendar.YEAR) + " " + gc.get(Calendar.MONTH) + " " + gc.get(Calendar.DAY_OF_MONTH));
        gc.add(Calendar.MONTH, 1);
        gc.add(Calendar.DAY_OF_MONTH, 9);
        System.out.println(gc.get(Calendar.YEAR) + " " + gc.get(Calendar.MONTH) + " " + gc.get(Calendar.DAY_OF_MONTH));
        System.out.println(gc.getTime());
    }

    @Test
    public void testRollAndAdd() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MAY, 7);
        log.info(sdf.format(calendar.getTime())); // 2020-05-07

        //calendar.add(Calendar.MONTH, 10); // 2021-03-07
        calendar.roll(Calendar.MONTH, 10); // 2020-03-07
        log.info(sdf.format(calendar.getTime()));
    }
}
