package com.design.service;

import com.design.model.Student;

import java.util.List;

public interface StudentService {
	Student findStudentById(int id);

	List<Student> findStudentByDepartmentId(int id);
	
	int saveStudent(Student student);
}
