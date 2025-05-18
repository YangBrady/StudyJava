package me.yangjun.study.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Student类的名称是：{}", Student.class.getName());
        log.info("Student类的共有方法：{}", Arrays.toString(Student.class.getMethods()));
        log.info("Student类的所有方法：{}", Arrays.toString(Student.class.getDeclaredMethods()));
        log.info("Student类的所有属性：{}", Arrays.toString(Student.class.getDeclaredFields()));
        // Student.class.getConstructor();

        try {
            People people = Student.class.getConstructor(new Class[] {}).newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
            | NoSuchMethodException | SecurityException e) {
            log.error("error", e);
        }
    }
}
