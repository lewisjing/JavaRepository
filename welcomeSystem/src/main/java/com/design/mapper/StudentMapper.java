package com.design.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.design.model.Student;

@Repository
public interface StudentMapper {
	@Select("Select * from student where id = #{id}")
	Student selectStudent(int id);
	
	@Select("select * from student where department_id = #{id}")
	Student findStudentByDepartmentId(int id);
	
	@Insert("insert into student(name, department_id) values(#{name}, #{departmentId})")
	int saveStudent(Student student);
}
