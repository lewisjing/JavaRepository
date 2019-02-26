package com.design.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.design.model.Student;

@Repository
public interface StudentMapper {
	@Select("Select * from student where id = #{id}")
	Student selectStudent(int id);
}
