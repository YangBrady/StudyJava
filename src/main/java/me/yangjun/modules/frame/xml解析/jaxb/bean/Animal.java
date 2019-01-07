package me.yangjun.modules.frame.xml解析.jaxb.bean;

public class Animal {
    private String petName;
    private int petAge;

    public Animal() {
    }

    public Animal(String petName, int petAge) {
        this.petName = petName;
        this.petAge = petAge;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }
}
