package me.yangjun.modules.frame.spring.demo.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Cat {
    private String name;
    private int age;
    private Toy toy;
    @Autowired
    private Food food;
    private Skill skill;

    public Cat() {
    }

    @Autowired
    public Cat(Skill skill) {
        this.skill = skill;
    }

    public void play() {
        this.toy.exexute();
    }

    public void eat() {
        this.food.teast();
    }

    public void showSkill() {
        this.skill.show();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Toy getToy() {
        return toy;
    }

    @Autowired
    public void setToy(Toy toy) {
        this.toy = toy;
    }


    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }


}
