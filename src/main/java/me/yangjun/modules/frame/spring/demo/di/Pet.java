package me.yangjun.modules.frame.spring.demo.di;

/**
 * Created by yangjun on 2018/12/14.
 */
public class Pet {
	private String petName;
	private int petAge;
	private boolean isMale;

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

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	@Override
	public String toString() {
		return "Pet [petName=" + petName + ", petAge=" + petAge + ", isMale=" + isMale + "]";
	}

	public Pet() {
		super();
	}

	public Pet(String petName, int petAge, boolean isMale) {
		super();
		this.petName = petName;
		this.petAge = petAge;
		this.isMale = isMale;
	}
}
