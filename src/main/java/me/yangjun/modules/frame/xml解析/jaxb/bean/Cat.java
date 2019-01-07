package me.yangjun.modules.frame.xml解析.jaxb.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cat extends Animal {
    private String loveThings;

    public Cat(String loveThings) {
        this.loveThings = loveThings;
    }

    public Cat(String petName, int petAge, String loveThings) {
        super(petName, petAge);
        this.loveThings = loveThings;
    }

    public String getLoveThings() {
        return loveThings;
    }

    public void setLoveThings(String loveThings) {
        this.loveThings = loveThings;
    }
}
