package com.design.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.mapper.StudentMapper;
import com.design.model.Student;
import com.design.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public Student findStudentById(int id) {
		Student student = studentMapper.selectStudent(id);
		return student;
	}

	@Override
	public Student findStudentByDepartmentId(int id) {
		Student student = studentMapper.findStudentByDepartmentId(id);
		return student;
	}

	@Override
	public int saveStudent(Student student) {
		
		return studentMapper.saveStudent(student);
	}

}
