package domain.entityImpl;

import domain.Entity;

public class Specialty extends Entity {

	private String name;
	private int set; // набор
	private int universityID;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	public int getUniversityID() {
		return universityID;
	}
	public void setUniversityID(int universityID) {
		this.universityID = universityID;
	}	
	
}
