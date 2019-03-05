package com.design.model;

public class Classroom {
	private Integer id;
	
	private String name;

	private String teacher;
	
//	private Profession profession;

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

//	public Profession getProfession() {
//		return profession;
//	}
//
//	public void setProfession(Profession profession) {
//		this.profession = profession;
//	}


	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}
