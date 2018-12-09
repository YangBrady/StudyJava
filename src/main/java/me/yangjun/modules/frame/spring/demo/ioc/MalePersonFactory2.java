package me.yangjun.modules.frame.spring.demo.ioc;

/**
 * Created by yangjun on 2018/12/6.
 */
public class MalePersonFactory2 {
    // 静态工厂类
    public MalePerson newInstance(String length) {
        return new MalePerson(length);
    }
}
