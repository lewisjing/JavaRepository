package com.design.model;

public class Student {
	private Integer id;
	
	private String name;
	
	private Department department;
	
	private Profession profession;
	
	private Classroom classroom;
	
	private boolean isPay;
	
	private int tuition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
}
