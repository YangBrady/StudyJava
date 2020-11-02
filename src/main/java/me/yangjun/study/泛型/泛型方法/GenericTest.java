package me.yangjun.study.泛型.泛型方法;

/**
 * @author mooejun
 * @since 2019/10/17
 */
public class GenericTest {

    // 这个类是个泛型类
    public class GenericClass<T> {
        private T key;

        public GenericClass(T key) {
            this.key = key;
        }

        // 虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        public T getKey() {
            return key;
        }

    }

    // 泛型方法
    public <K> void test(K k) {

    }
}