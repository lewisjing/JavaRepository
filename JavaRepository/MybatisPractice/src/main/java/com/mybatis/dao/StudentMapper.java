package com.mybatis.dao;

import com.mybatis.model.Student;

import java.util.List;

public interface StudentMapper {
    Student findStudentById(int id);

    List<Student> findStudentByIdLazyLoad();
}
