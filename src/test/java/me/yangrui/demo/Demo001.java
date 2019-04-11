package me.yangrui.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mooejun
 * @since 2019/3/6
 */
public class Demo001 {

    @Test
    public void test001() {
        Map<String, Student> studentMap = new HashMap<>();
        Student s1 = new Student("aa", 10, "4");
        studentMap.put("s1", s1);

        s1.setAge(12);

        Student aStudent = studentMap.get("s1");
        System.out.println(aStudent.getAge());
    }
}
