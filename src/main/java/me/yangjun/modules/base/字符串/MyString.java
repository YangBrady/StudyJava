package me.yangjun.modules.base.字符串;

/**
 * Created by 杨峻 on 2016/10/20.
 */
public class MyString {
    public static void main(String[] args) {
        MyString ms = new MyString();
        ms.checkString();

        MyStringBuilder msder = new MyStringBuilder();
        msder.doSomething();

    }

    public void checkString() {
        String str = "";
        if (str != null && str.length() != 0) { // 判断是否未赋值并且不是空字符串
            System.out.println("str:" + str);
        } else {
            System.out.println("");
        }
    }

}

class MyStringBuilder { //速度最快
    public void doSomething() {
        StringBuilder str = new StringBuilder("Hello");
        System.out.println(str.toString());
        str.append('!');
        System.out.println(str);
        str.delete(0, 1);
        System.out.println(str);
    }
}

class MyStringBuffer { //支持多线程
    public void doSomething() {
        StringBuffer str = new StringBuffer("Hello");
        System.out.println(str.toString());
        str.append('!');
        System.out.println(str);
        str.delete(0, 1);
        System.out.println(str);
    }
}