package me.yangjun.study.di;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by yangjun on 2018/12/13.
 */
public class MalePerson extends Person {
    private String work;
    private int workYear;
    private String workPlace;
    private Pet pet;
    private Pet[] hatePets;
    private String[] hateNumber;
    private List<Pet> lovePets;
    private List<String> loveNumber;
    private Map<String, Pet> petHis;
    private Map<String, String> NumberHis;

    public MalePerson() {
        super();
    }

    public MalePerson(String work, int workYear) {
        super();
        this.work = work;
        this.workYear = workYear;
    }

    public MalePerson(String work, int workYear, String workPlace) {
        super();
        this.work = work;
        this.workYear = workYear;
        this.workPlace = workPlace;
    }

    public MalePerson(String work, int workYear, String workPlace, Pet pet) {
        super();
        this.work = work;
        this.workYear = workYear;
        this.workPlace = workPlace;
        this.pet = pet;
    }

    public MalePerson(String work, int workYear, String workPlace, Pet pet,
                      Pet[] hatePets, String[] hateNumber, List<Pet> lovePets,
                      List<String> loveNumber, Map<String, Pet> petHis, Map<String, String> numberHis) {
        this.work = work;
        this.workYear = workYear;
        this.workPlace = workPlace;
        this.pet = pet;
        this.hatePets = hatePets;
        this.hateNumber = hateNumber;
        this.lovePets = lovePets;
        this.loveNumber = loveNumber;
        this.petHis = petHis;
        NumberHis = numberHis;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getWorkYear() {
        return workYear;
    }

    public void setWorkYear(int workYear) {
        this.workYear = workYear;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet[] getHatePets() {
        return hatePets;
    }

    public void setHatePets(Pet[] hatePets) {
        this.hatePets = hatePets;
    }

    public String[] getHateNumber() {
        return hateNumber;
    }

    public void setHateNumber(String[] hateNumber) {
        this.hateNumber = hateNumber;
    }

    public List<Pet> getLovePets() {
        return lovePets;
    }

    public void setLovePets(List<Pet> lovePets) {
        this.lovePets = lovePets;
    }

    public List<String> getLoveNumber() {
        return loveNumber;
    }

    public void setLoveNumber(List<String> loveNumber) {
        this.loveNumber = loveNumber;
    }

    public Map<String, Pet> getPetHis() {
        return petHis;
    }

    public void setPetHis(Map<String, Pet> petHis) {
        this.petHis = petHis;
    }

    public Map<String, String> getNumberHis() {
        return NumberHis;
    }

    public void setNumberHis(Map<String, String> numberHis) {
        NumberHis = numberHis;
    }

    @Override
    public String toString() {
        return "MalePerson{" +
                "work='" + work + '\'' +
                ", workYear=" + workYear +
                ", workPlace='" + workPlace + '\'' +
                ", pet=" + pet +
                ", hatePets=" + Arrays.toString(hatePets) +
                ", hateNumber=" + Arrays.toString(hateNumber) +
                ", lovePets=" + lovePets +
                ", loveNumber=" + loveNumber +
                ", petHis=" + petHis +
                ", NumberHis=" + NumberHis +
                '}';
    }
}
