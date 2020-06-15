package me.yangjun.study.ioc;

/**
 * Created by yangjun on 2018/12/6.
 */
public class MalePersonFactory {
    // 静态工厂类
    public static MalePerson newInstance(String length) {
        return new MalePerson(length);
    }
}
