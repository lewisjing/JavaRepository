package com.design.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.design.model.Student;

import java.util.List;

@Repository
public interface StudentMapper {
	@Select("Select * from student where id = #{id}")
	Student selectStudent(int id);
	
	@Select("select * from student where department_id = #{id}")
	List<Student> findStudentByDepartmentId(int id);
	
	@Insert("insert into student(name, department_id, profession_id, ispay, tuition, classroom_id, identity_num, student_id, telephone, address, dormitory_id) " +
			"values(#{name}, #{department.id}, #{profession.id}, #{pay}, #{tuition}, #{classroom.id}, #{identityNum}, #{studentId}, #{telephone}, #{address}, #{dormitory.id})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int saveStudent(Student student);

	@Update("update student set name=#{name}, department_id=#{department.id}, ispay=#{ispay}, tuition=#{tuition}, classroom_id=#{classroom.id}" +
			"identity_num=#{identityNum}, student_id=#{studentId}, telephone=#{telephone}, address=#{address}, dormitory_id=#{dormitory.id} where id=#{id}")
	int updateStudent(Student student);

	@Select("select * from student where dormitory_id = #{id}")
	List<Student> findStudentByDormitoryId(int id);

	@Select("select * from student where classroom_id = #{id}")
	List<Student> findStudentByClassroomId(int id);

}
