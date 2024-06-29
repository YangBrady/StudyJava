package me.yangjun.study.泛型.typereference;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * TypeReference Demo
 */
@Slf4j
public class TypeReferenceDemo {

    static class Wrapper<T> {
    }

    /**
     * 获取通用运行时类型
     *
     * @param wrapper 包装类
     * @return {@link Type }
     */
    public static <T> Type getGenericRuntimeType(Wrapper<T> wrapper) {
        Type type = wrapper.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }

        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            return types[0];
        }
        return null;
    }

    public void main(String[] args) {
        // 普通泛型实例化
        Type type1 = getGenericRuntimeType(new Wrapper<List<String>>());
        // 在运行时 List<String> 的具体类型信息将被擦除，只保留原始类型信息 (List)
        log.info("type1={}", type1); // type1=null

        // 带有匿名类的实例化
        Type type2 = getGenericRuntimeType(new Wrapper<List<String>>() {
        });
        // 由于匿名类的存在，可以通过反射获取完整的泛型类型信息，包括 List<String> 中的 String。
        log.info("type2={}", type2); // type2=java.util.List<java.lang.String>
    }
}
