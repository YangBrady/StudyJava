package me.yangjun.modules.base.泛型;

import me.yangjun.modules.base.泛型.泛型类.GenericClass01;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mooejun
 * @since 2019/05/28
 */
public class GenericDemo {

    // 不使用泛型的例子, 非指定类型会抛出类型转换异常
    @Test
    public void demo001() {
        List list = new ArrayList();
        list.add("aaa");
        list.add(100);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));
        }
    }

    // 使用泛型的例子
    @Test
    public void demo002() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
//        list.add(100); 编译的时候就会报错
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 泛型通配符, T、E、K、V等主要用于声明泛型, ?主要用于使用泛型
    @Test
    public void demo003() {
        GenericClass01<? extends Object> gc1 = new GenericClass01<String>();
        //GenericClass01<? super Object> gc2 = new GenericClass01<String>();
    }
}
