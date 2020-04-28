package com.mybatis.dao;

import com.mybatis.model.Class;
import com.mybatis.model.Student;

import java.util.List;

public interface ClassMapper {
    List<Student> findStudentsByClass(int id);

    List<Class> findClassLazyLoad();
}
