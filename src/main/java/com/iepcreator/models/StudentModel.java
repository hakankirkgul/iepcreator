package com.iepcreator.models;

import java.util.Date;

public class StudentModel {

	private int studentId;
	private String name;
	private String surname;
	private String gender; 
	private Date birthDate; 
	private String parentName;
	private String parentSurname;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentSurname() {
		return parentSurname;
	}
	public void setParentSurname(String parentSurname) {
		this.parentSurname = parentSurname;
	}

}
