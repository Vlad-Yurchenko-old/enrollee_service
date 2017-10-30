package domain.entityImpl;

import domain.Entity;

public class Enrollee extends Entity {

	private String name;
	private String surName;
	private String lastName;
	private String city;
	private String gender;
	private int score; // балл аттестата
	private int specialtyID;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSpecialtyID() {
		return specialtyID;
	}
	public void setSpecialtyID(int specialtyID) {
		this.specialtyID = specialtyID;
	}
	
}
