package me.yangjun.modules.base.反射;

public class Main {

    public static void main(String[] args) {
        //Student a = new Student();
        System.out.println("Student类的名称是：" + Student.class.getName()); //com.inzte.Student
        System.out.println("Student类的共有方法：" + Student.class.getMethods());
        System.out.println("Student类的所有方法：" + Student.class.getDeclaredMethods());
        System.out.println("Student类的所有属性：" + Student.class.getDeclaredFields());


        //Student.class.getConstructor();


        //Object objectCopy=Student.class.getConstructor(new Class[]{}).newInstance(new Object[]{});
    }
}


class Student {

    private String firstName;
    private int age;
    private char sex;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void methodA(){
        System.out.println("1");
    }
}