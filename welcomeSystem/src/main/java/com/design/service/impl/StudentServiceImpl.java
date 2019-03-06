package com.design.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.mapper.StudentMapper;
import com.design.model.Student;
import com.design.service.StudentService;

import java.util.List;

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
	public List<Student> findStudentByDepartmentId(int id) {
		List<Student> students = studentMapper.findStudentByDepartmentId(id);
		return students;
	}

	@Override
	public int saveStudent(Student student) {
		if (student.getId() != null) {

		}
		return studentMapper.saveStudent(student);
	}

}
