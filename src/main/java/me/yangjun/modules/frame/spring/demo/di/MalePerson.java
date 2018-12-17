package me.yangjun.modules.frame.spring.demo.di;

/**
 * Created by yangjun on 2018/12/13.
 */
public class MalePerson extends Person {
	private String work;
	private int workYear;
	private String workPlace;
	private Pet pet;

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

	@Override
	public String toString() {
		return "MalePerson [work=" + work + ", workYear=" + workYear + ", workPlace=" + workPlace + ", pet=" + pet
				+ "]";
	}

}
