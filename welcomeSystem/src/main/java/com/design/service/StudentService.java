package com.design.service;

import com.design.model.Student;

public interface StudentService {
	Student findStudentById(int id);
	
	Student findStudentByDepartmentId(int id);
	
	int saveStudent(Student student);
}
