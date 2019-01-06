package me.yangjun.modules.frame.spring.demo.di.autowired;

public class Person {
    private String name;
    private Cat cat;
    private Dog dog;

    public Person() {
    }

    public Person(String name, Cat cat, Dog dog) {
        this.name = name;
        this.cat = cat;
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
