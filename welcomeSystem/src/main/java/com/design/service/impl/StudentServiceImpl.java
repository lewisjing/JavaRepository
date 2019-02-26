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

}
