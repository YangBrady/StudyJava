package me.yangjun.study.集合类.collection.list;

import me.yangjun.study.集合类.entity.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        // List接口特有方法：get(),返回列表中指定元素
        // Arrays.asList()和Collection.toArray()是作为数组和集合类的一个桥

        ListTest a = new ListTest();
        a.testChange();
    }

    /**
     * ArrayList
     */
    // 自动增长容量就是当数组不够的时候,再定义更大的数组，然后将数组元素拷贝到新的数组
    public void arrayListTest() {
        ArrayList<String> a = new ArrayList<>();
        a.add("apple");
        a.add("book");
        a.add("cola");

        Iterator<String> it = a.iterator();

        for (String s : a) {
            System.out.println(s);
        }
        System.out.println(a);
    }

    /**
     * LinkedList
     */
    public void linkedListTest() {
        LinkedList<String> a = new LinkedList<>();
        a.add("winsun");
        a.add("book");
        a.add("cola");

        for (String s : a) {
            System.out.println(s);
        }
        System.out.println(a);
    }

    // 集合类中存对象的时候存的是对象的引用，当对象的引用指向的地址发生改变的时候List里面的数据不变，但是不是原先的数据了。
    public void testChange() {
        Person p1 = new Person();
        p1.setName("aa");
        p1.setAge("10");

        Person p2 = new Person();
        p2.setName("bb");
        p2.setAge("20");

        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);

        System.out.println(persons);// [(name:aa age:10), (name:bb age:20)]

        p1.setAge("15");
        System.out.println(persons);// [(name:aa age:15), (name:bb age:20)]
    }
}